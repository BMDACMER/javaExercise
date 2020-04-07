



## 一、JUC 系统学习

### 1 JUC是什么





## 二、JVM

> 针对应聘要求：
>
> 熟悉JVM架构与GC垃圾回收机制以及相应的堆参调优，有过在linux进行系统调优的经验

广泛使用的三个虚拟机：***HotSpotJVM***（使用最广泛默认该虚拟机） 、***OracleJRockit*** 、***IBM JVM***

![image-20200406171803222](E:\dev\javaweb\IDEA\javaExercise\images\JVM.png)

1. Class Loader类加载器
    负责加载class文件，class文件在文件开头有特定的文件标示，并且ClassLoader只负责class文件的加载，至于它是否可以允许，则由Execution Engine决定

2. Execution Engine执行引擎 负责解释命令，提交操作系统执行

3. Native Interface 本地接口
    Java语言本身不能对操作系统底层进行访问和操作，但是可以通过JNI(Java Native Interface)接口调用其他语言来实现对底层的访问。

4. Native Method Stack 本地方法栈
    java在内存中专门开辟了一块区域处理标记为native的代码，它的具体做法是Native Method Stack中登记
    native方法，在Execution Engine执行时加载native libraies。

5. Runtime Data Area 运行数据区

6. Method Area方法区
    方法区是被所有线程共享，所有字段和方法字节码、以及一些特殊方法如构造函数，接口代码也在此定义。简
    单说，所有定义的方法的信息都保存在该区域，此区属于共享区间。用来保存装载的类的元结构信息。
    ```静态变量+常量+类信息+运行时常量池存放在方法区```
    实例变量存在堆内存中

7. PC Register 程序计数器
    每个线程都有一个程序计数器，就是一个指针，指向方法区中的方法字节码（下一个将要执行的指令代码），有执行引擎读取下一条指令，是一个非常小的内存空间，可以忽略不记
    `栈管运行，堆管存储`

8. Java Stack 栈
    栈也叫栈内存，主管Java程序的运行，是在线程创建时创建，它的生命期是跟随线程的生命期，线程结束栈内
    存也就释放，对于栈来说不存在垃圾回收问题，只要线程一结束该栈就Over，生命周期和线程一致，是线程私有的。基本类型的变量、实例方法、引用类型变量都是在函数的栈内存中分配。

  

### 1 类加载器

**类装载器ClassLoader1**

![image-20200406174435618](E:\dev\javaweb\IDEA\javaExercise\images\ClassLoader1.png)

**类装载器ClassLoader2**

![image-20200406174608029](E:\dev\javaweb\IDEA\javaExercise\images\ClassLoader2.png)

```java
public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());
//        System.out.println(object.getClass().getClassLoader().getParent());  // Exception in thread "main" java.lang.NullPointerException
        System.out.println(object.getClass().getClassLoader());  // null

        System.out.println("\n\n\n\n");

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());  // null
        System.out.println(myObject.getClass().getClassLoader().getParent()); // sun.misc.Launcher$ExtClassLoader@677327b6
        System.out.println(myObject.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
```



#### 1.1 获取ClassLoader的途径

方式一：获取当前类的ClassLoader
clazz.getClassLoader()
方式二： 获取当前线程上下文的ClassLoader
Thread.currentThread().getContextClassLoder()
方法三：系统的ClassLoader
ClassLoader.getSystemClassLoader()
方法四： 获取调用者的ClassLoader
DriverManger.getCallerClassLoader()

```java
// 获取几种ClassLoader现象
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //1
        ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader);   // null

        //2
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1);   // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 3
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(classLoader2);   // sun.misc.Launcher$ExtClassLoader@677327b6
    }
}

```

#### 1.2 双亲委派机制

**工作原理**

> 如果一个类加载器收到了类加载请求，它并不会自己先去加载，而是把这个请求委托给父类的加载器去执行；如果父类加载器还存在其父亲加载器，则进一步向上委托，一次递归，请求最终将到达顶层的启动类加载器；如果父亲加载器可以完成类加载任务，就成功返回，倘若父亲加载器无法完成加载任务，子加载器才会尝试自己去加载，这就是双亲委派模式。

![image-20200407100908578](E:\dev\javaweb\IDEA\javaExercise\images\ClassLoader3.png)

**优势**

> 避免类的重复加载
>
> 包括程序安全，防止核心API呗随意篡改
>
> > 自定义类：java.lang.String
> >
> > 自定义类：java.lang.ShkStart

#### 1.3 沙箱安全机制

**概念**

> 自定义String类，但是在加载自定义String类的时候会率先使用引导类加载器加载，而引导类加载器在加载的过程中会先加载jdk自带的文件(tr.jar包中java\lang\String.class)，报错信息说没有main方法就是因为加载的是rt.jar包中的String类。这样可以保证对java核心源代码的保护，这就是沙箱安全机制。

### 2 运行时数据区

![image-20200407102843846](E:\dev\javaweb\IDEA\javaExercise\images\Method1.png)

#### 2.1 程序计数器（PCR）

![image-20200407104335481](E:\dev\javaweb\IDEA\javaExercise\images\Method2.png)

```java
public class PCRegister {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = i + j;

        String s = "abc";
        System.out.println(i);
        System.out.println(k);
    }
}
```

>  使用 javap -verbose PCRegister.class 

![image-20200407105124763](E:\dev\javaweb\IDEA\javaExercise\images\Method3.png)

![image-20200407105721306](E:\dev\javaweb\IDEA\javaExercise\images\Method4.png)

**PC寄存器为什么会被设定为线程私有？**

> 多线程在一个特定的时间段内只会执行其中一个线程的方法，CPU会不停地做任务切换，这样必然导致经常中断或恢复，如何保证分号无差呢？
>
> 为了能够准确地记录各个线程正在执行的当前字节码指令地址，最好的办法自然是为每一个线程都分配一个PC寄存器，这样一来各个线程之间便可以进行独立计算，从而不会出现相互干扰的情况。

由于CPU的时间片轮限制，众多线程在并发执行过程中，任何一个确定的时刻，一个处理器或多核处理器中的一个内核，只会执行某个线程中的一条指令。这样必然导致经常中断或恢复，因此，每个线程在创建后，都会产生自己的程序计数器和栈帧，程序计数器在各个线程之间互补影响。

#### 2.2 虚拟机栈

> 栈式运行时的单位，而堆式存储的单位

![image-20200407112210333](E:\dev\javaweb\IDEA\javaExercise\images\Method5.png)

**概念**

> java虚拟机栈（java Virtual MAchine Stack），早期也叫java栈。每个线程在创建时都会创建一个虚拟机栈，其内部保存一个个的栈帧（Stack Frame），对应着一次次的java方法调用。  是线程私有的

**生命周期**

> 声明周期与线程一致

**作用**

> 主管java程序的运行，它保存方法的局部变量（8种基本数据类型、对象的引用地址）、部分结果，并参与方法的调用和返回。
>
> 局部变量 VS 成员变量（或属性）
>
> 基本数据变量 VS  引用类型变量（类、数组、接口）

**优点**

> 栈式一种快速有效的分配存储的方式，访问速度仅次于程序计数器。
>
> JVM直接堆java帧的操作只有两个：
>
> > 每个方法执行，伴随着进栈（入栈、压栈）
> >
> > 执行结束后的出栈工作
> >
> 

> 对于栈来说不存在垃圾回收问题



面试中虚拟机栈涉及的问题？

答：StackOverflowError  和 OutOfMemoryError异常

设置栈的大小：`-Xss`       eg: -Xss1024k

##### 2.2.1 栈的内部结构

![image-20200407114627920](E:\dev\javaweb\IDEA\javaExercise\images\Stack1.png)

##### 2.2.2 局部变量表

`概念`：局部变量表也称之为局部变量数组或本低变量表。定义为一个数字数组，主要用于存储方法参数和定义在方法体内的局部变量，这些数据类型包括各类基本数据类型、对象引用（Reference），以及returnAddress类型。

由于局部变量表式建立在线程的栈上，是线程的私有数据，因此`不存在数据安全问题`。

局部变量表所需的容量大小是在编译期确定下来的，并保存在方法的Code属性的`maximun local variables`数据项中，在方法运行期间是不会改变局部变量表的大小的。

局部变量表，最基本的存储单元式`Slot`（变量槽）

在局部变量表里，32位以内的类型只占用一个slot（包括returnAddress类型），64位的类型（long和doube）占用两个slot。



**变量的分类**：按照数据类型分：① 基本数据类型  ②引用数据类型

​						按照在类中声明的位置分：①成员变量： 在使用前，都经历过默认初始化赋值

​																					类变量：linking的prepare阶段：给类变量默认赋值

​																					实例变量：随着对象的创建，会在堆空间总分配时变量空间，进行默认赋值

​																		②局部变量：在使用前，必须要进行显示赋值的！ 否则，编译不通过。

**补充说明**：局部变量表中的变量也是重要的垃圾回收根节点，只要被局部变量表中直接或间接引用的对象都不会被回收。

##### 2.2.3 操作数栈

操作数栈：主要用于保存计算过程的中间结果，同时作为计算过程中变量麟视的存储空间

栈中的任何一个元素都是可以任意的java数据类型：

> 32bit的类型占用一个栈单位深度
>
> 64bit的类型占用两个栈单位深度

操作数栈并非采用访问索引的方式来进行数据访问的，而是只能通过标准的入栈（push）和出栈（pop）操作来完成一次数据访问。

##### 2.2.4 动态链接

也即 指向运行时常量池的方法引用。

每一个栈帧内部都包含一个指向运行时常量池中该栈帧所属方法的引用包含这个引用的目的就是为了支持当前方法的代码能够实现动态链接。比如： invokedynamic 指令

动态链接的作用就是为了将这些符号引用转换为调用方法的直接引用。

为什么需要常量池呢？答：常量池的作用就是为了提供一些符号和常量，便于指令的识别。

**方法的调用**

> 在JVM中，将符号引用转换为调用方法的直接引用与方法的绑定机制相关
>
> 静态链接  -------对应于-------> 早期绑定
>
> > 被调用的目标方法在编译期可知，且运行期保持不变。这种情况下将调用方法的符号引用转换为直接引用的过程称之为静态链接。
>
> 动态链接  -------对应于-------> 晚期绑定
>
> > 如果被调用的方法在编译期无法被确定下来，也就是说，只能在程序运行期将调用方法的符号引用转换为直接引用，成为动态链接。

> 非虚方法与虚方法
>
> > 如果方法在编译期就确定了具体的调用版本，这个版本在运行时是不可变的，这样的方法成为非虚方法。
> >
> > eg：静态方法、私有方法、final方法、实例构造器、父类方法都是非虚方发。其他方法称为虚方法
>
> 动态类型语言与静态类型语言
>
> > 静态类型语言是判断变量自身的类型信息；动态类型语言是判断变量值的类型信息，变量没有类型信息，变量值才有类型信息。

##### 2.2.5 方法返回地址

存放调用该方法的pc寄存器的值

一个方法的结束，有两种方式：

- 正常执行完毕
- 出现未处理的异常，非正常退出

方法正常退出时，调用者的pc计数器的值作为返回地址，即调用该方法的指令的下一条指令的地址。而通过异常退出的，返回地址是要通过异常表来确定，栈帧中一般不会保存这部分信息。

##### 2.2.6 一些附加信息

栈帧中还允许写代与java虚拟机实现相关的一些附加信息。例如，对程序调试提供支持的信息。

##### 小结

- 举例栈溢出的情况？（StackOverflowError）
  - 通过 -Xss 设置栈的大小，OOM
- 调整栈大小，就能保证不出现溢出吗？ 不能
- 分配的栈内存越大越好吗？ 不是！
- 垃圾回收始符会涉及到虚拟机栈？不会！（GC只对运行时数据区中的堆和方法区回收）
- 方法中定义的局部变量是否线程安全？具体问题具体分析
  - 如果只有一个线程才可以操作此数据，则必是线程安全的
  - 如果有多个线程操作此数据，则此数据是共享数据。如果不考虑同步机制的话，会存在线程安全问题

#### 3 本地方法栈

![image-20200407180046444](E:\dev\javaweb\IDEA\javaExercise\images\Stack.png)

当某个线程调用一个本地方法时，它就进入了一个全新的并且不再受虚拟机限制的世界。它和虚拟机拥有统样的权限。本地方法可以通过本地方法接口直接访问虚拟机内部的运行时数据区。

并不是所有的JVM都支持本地方法。因为java虚拟机规范并没有明确要求本地方法的使用语言、具体实现方式、数据结构等。

#### 4 方法区

存储了每一个`类的结构信息`。例如：运行时常量池、字段和方法数据、构造函数和普通方法的字节码内容。在不同虚拟机里头实现是不一样的，最典型的就是永久代（PermGen space）和元空间（Metspace）。

`实例变量存在堆内存中和方法区无关`

#### 5 堆

> 栈管运行，堆管存储

一个JVM实例只存在一个堆内存，堆内存的大小是可以调节的。类加载器读取了类文件后，需要把类、方法、常量放到堆内存中，保存所有引用类型的真实信息，以方便执行器执行，堆内存分为三部分：`新生区`  、`养老区` 、`永久区`（JDK8之后换为`元空间`）。

![image-20200407182750793](E:\dev\javaweb\IDEA\javaExercise\images\Heap7.png)

- Eden 满了，开启
  - GC = YGC = 轻GC
  - Eden基本全部清空
  - S0 = from  /  S1 = to
  - from区和to区，他们的位置和名分，不是固定的，每次GC后会交换。GC之后有交换，谁空谁是to
- old养老区，满了，开启
  - Full GC = FGC
  - Full GC 多次，发现养老区空间没办法腾出来
  - OOM 堆内存溢出



![image-20200407184509142](E:\dev\javaweb\IDEA\javaExercise\images\heap2)

![image-20200407185152860](E:\dev\javaweb\IDEA\javaExercise\images\heap3)



**堆参数调优**

![image-20200407185626665](E:\dev\javaweb\IDEA\javaExercise\images\heap4)

`-Xms` ------> 初始化栈大小 

`-Xmx`----->栈调节最大限度

![image-20200407185747355](E:\dev\javaweb\IDEA\javaExercise\images\heap5)

元空间与永久区之间最大的区别在于：

> 永久代使用的JVM的堆内存，但是java8以后的元空间并不在虚拟机中而是使用本机物理内存。
>
> 因此，默认情况下，元空间的大小仅受本地内存限制。类的元数据放入native memory，字符串和类的静态变量放入java堆中，这样可以加载多少泪的元数据就不在由MaxPermSize控制，而由系统的实际可用空间来控制。

![image-20200407190436149](E:\dev\javaweb\IDEA\javaExercise\images\heap6)



### 3 本地方法

简单来讲，一个Native Method就是一个java调用非java代码的接口。一个Native Method是这样一个java方法：该方法的实现由非java语言实现，比如C。

在定义一个native method时，并不提供实现体（有些像定义一个java interface），因为其实现体是由非java语言在外面实现的。

现状：目前该方法使用的越来越少了，除非是与硬件有关的应用。比如，通过java程序驱动打印机或者java系统管理生产设备，在企业级应用中已经比较少见。

### 4 总结

#### 4.1 组成结构

**ClassLoader类加载器**：负责加载class文件，class文件在文件开头有特定的文件标识，并且ClassLoader只负责class文件的加载，至于它是否可以允许，则由Execution Engine决定。

**Execution Engine**执行引擎：负责解释命令，提交操作系统执行

**Native Interface本地接口**：java语言本身不能对操作系统底层进行访问和操作，但是可以通过JNI（java native interface）接口掉哟个其他语言来实现对底层的访问。

**Native Method Stack 本地方法栈**：java在内存中开辟了一块区域处理标记为native的代码，它的具体做法是Native Method Stack中等级native方法，在Excution Engine执行时加载native libraies

**Runtime Data Area**：运行数据区

**Method Area方法区**：方法区是被所有线程共享，所有字段和方法字节码、以及一些特殊方法如构造函数，接口代码也在此定义。简单说，所有定义的方法的信息都保存在该区域，此区属于共享区间。用来保存装载的类的元结构信息。静态变量+常量+类信息+运行时常量池存放在方法区，实例变量存在堆内存中。

**PC Register程序计数器**：每个线程都有一个程序计数器，就是一个指针，指向方法区中的方法字节码（下一个将要执行的指令代码），有执行引擎读取下一条指令，是一个非常小的内存空间，可以忽略不记

**Java Stack栈**：栈也叫栈内存，主管Java程序的运行，是在线程创建时创建，它的生命期是跟随线程的生命期，线程结束栈内存也就释放，对于栈来说不存在垃圾回收问题，只要线程一结束该栈就Over，生命周期和线程一致，是线程私有的。基本类型的变量、实例方法、引用类型变量都是在函数的栈内存中分配。

#### 4.2 GC 垃圾回收

 ![image-20200407211125888](E:\dev\javaweb\IDEA\javaExercise\images\heap8.png)

 ![image-20200407211220756](E:\dev\javaweb\IDEA\javaExercise\images\GC1.png)

#####  4.2.1 GC四大算法

 **GC算法概述**

![image-20200407214518915](E:\dev\javaweb\IDEA\javaExercise\images\GC2)

JVM在进行GC时，并非每次都对上面三个内存区域一起回收的，大部分时候回收的都是指新生代。
因此GC按照回收的区域又分了两种类型，一种是普通GC（minor GC），一种是全局GC（major GC or Full GC）

Minor GC和Full GC的区别

> 普通GC（minor GC）：只针对新生代区域的GC,指发生在新生代的垃圾收集动作，因为大多数Java对象存活       率都不高，所以Minor GC非常频繁，一般回收速度也比较快。 
>
> 全局GC（major GC or Full GC）：指发生在老年代的垃圾收集动作，出现了Major GC，经常会伴随至少一次的Minor GC（但并不是绝对的）。Major GC的速度一般要比Minor GC慢上10倍以上 



**1）引用计数法**

![image-20200407215058977](E:\dev\javaweb\IDEA\javaExercise\images\PC1)

```java
 
/**@Description:-verbose:gc*/
public class RefCountGC
{
  private byte[] bigSize = new byte[2 * 1024 * 1024];//这个成员属性唯一的作用就是占用一点内存
  Object instance = null;
 
  public static void main(String[] args)
  {
    RefCountGC objectA = new RefCountGC();
    RefCountGC objectB = new RefCountGC();
    objectA.instance = objectB;
    objectB.instance = objectA;
    objectA = null;
    objectB = null;
 
    System.gc();
  }
}
```

**2）复制算法**

年轻代中使用的是Minor GC，这种GC算法采用的是复制算法(Copying)

**原理**

![image-20200407215433829](E:\dev\javaweb\IDEA\javaExercise\images\young1.png)

Minor GC会把Eden中的所有活的对象都移到Survivor区域中，如果Survivor区中放不下，那么剩下的活的对象就被移到Old  generation中，也即一旦收集后，Eden是就变成空的了。
当对象在 Eden ( 包括一个 Survivor 区域，这里假设是 from 区域 ) 出生后，在经过一次 Minor GC 后，如果对象还存活，并且能够被另外一块 Survivor 区域所容纳( 上面已经假设为 from 区域，这里应为 to 区域，即 to 区域有足够的内存空间来存储 Eden 和 from 区域中存活的对象 )，则使用复制算法将这些仍然还存活的对象复制到另外一块 Survivor 区域 ( 即 to 区域 ) 中，然后清理所使用过的 Eden 以及 Survivor 区域 ( 即 from 区域 )，并且将这些对象的年龄设置为1，以后对象在 Survivor 区每熬过一次 Minor GC，就将对象的年龄 + 1，当对象的年龄达到某个值时 ( 默认是 15 岁，通过-XX:MaxTenuringThreshold 来设定参数)，这些对象就会成为老年代。

-XX:MaxTenuringThreshold — 设置对象在新生代中存活的次数

**解释**

年轻代中的GC,主要是复制算法（Copying）

 HotSpot JVM把年轻代分为了三部分：1个Eden区和2个Survivor区（分别叫from和to）。默认比例为8:1:1,一般情况下，新创建的对象都会被分配到Eden区(一些大对象特殊处理),这些对象经过第一次Minor GC后，如果仍然存活，将会被移到Survivor区。对象在Survivor区中每熬过一次Minor GC，年龄就会增加1岁，当它的年龄增加到一定程度时，就会被移动到年老代中。因为年轻代中的对象基本都是朝生夕死的(90%以上)，所以在年轻代的垃圾回收算法使用的是复制算法，复制算法的基本思想就是将内存分为两块，每次只用其中一块，当这一块内存用完，就将还活着的对象复制到另外一块上面。复制算法不会产生内存碎片。

![image-20200407215715378](E:\dev\javaweb\IDEA\javaExercise\images\young2)

在GC开始的时候，对象只会存在于Eden区和名为“From”的Survivor区，Survivor区“To”是空的。紧接着进行GC，Eden区中所有存活的对象都会被复制到“To”，而在“From”区中，仍存活的对象会根据他们的年龄值来决定去向。年龄达到一定值(年龄阈值，可以通过-XX:MaxTenuringThreshold来设置)的对象会被移动到年老代中，没有达到阈值的对象会被复制到“To”区域。经过这次GC后，Eden区和From区已经被清空。这个时候，“From”和“To”会交换他们的角色，也就是新的“To”就是上次GC前的“From”，新的“From”就是上次GC前的“To”。不管怎样，都会保证名为To的Survivor区域是空的。Minor GC会一直重复这样的过程，直到“To”区被填满，“To”区被填满之后，会将所有对象移动到年老代中。

![image-20200407215925366](E:\dev\javaweb\IDEA\javaExercise\images\young3)

因为Eden区对象一般存活率较低，一般的，使用两块10%的内存作为空闲和活动区间，而另外80%的内存，则是用来给新建对象分配内存的。一旦发生GC，将10%的from活动区间与另外80%中存活的eden对象转移到10%的to空闲区间，接下来，将之前90%的内存全部释放，以此类推。

**缺点**

复制算法它的缺点也是相当明显的。 

- 它浪费了一半的内存，这太要命了。 
- 如果对象的存活率很高，我们可以极端一点，假设是100%存活，那么我们需要将所有对象都复制一遍，并将所有引用地址重置一遍。复制这一工作所花费的时间，在对象存活率达到一定程度时，将会变的不可忽视。 所以从以上描述不难看出，复制算法要想使用，最起码对象的存活率要非常低才行，而且最重要的是，我们必须要克服50%内存的浪费。

**3）标记-清除算法（Mark-Sweep）**

老年代一般是由标记清除或者是标记清除与标记整理的混合实现。

![image-20200407220151783](E:\dev\javaweb\IDEA\javaExercise\images\old1.png)

用通俗的话解释一下标记清除算法，就是当程序运行期间，若可以使用的内存被耗尽的时候，GC线程就会被触发并将程序暂停，随后将要回收的对象标记一遍，最终统一回收这些对象，完成标记清理工作接下来便让应用程序恢复运行。

主要进行两项工作，第一项则是标记，第二项则是清除。  
标记：从引用根节点开始标记遍历所有的GC Roots， 先标记出要回收的对象。
清除：遍历整个堆，把标记的对象清除。 
此算法需要暂停整个应用，会产生内存碎片 。

**缺点**

1、首先，它的缺点就是效率比较低（递归与全堆对象遍历），而且在进行GC的时候，需要停止应用程序，这会导致用户体验非常差劲。
2、其次，主要的缺点则是这种方式清理出来的空闲内存是不连续的，这点不难理解，我们的死亡对象都是随即的出现在内存的各个角落的，现在把它们清除之后，内存的布局自然会乱七八糟。而为了应付这一点，JVM就不得不维持一个内存的空闲列表，这又是一种开销。而且在分配数组对象的时候，寻找连续的内存空间会不太好找。 

 **4）标记压缩(Mark-Compact)**

老年代一般是由标记清除或者是标记清除与标记整理的混合实现。

![image-20200407220430669](E:\dev\javaweb\IDEA\javaExercise\images\old2)

在整理压缩阶段，不再对标记的对像做回收，而是通过所有存活对像都向一端移动，然后直接清除边界以外的内存。
可以看到，标记的存活对象将会被整理，按照内存地址依次排列，而未被标记的内存会被清理掉。如此一来，当我们需要给新对象分配内存时，JVM只需要持有一个内存的起始地址即可，这比维护一个空闲列表显然少了许多开销。 

标记/整理算法不仅可以弥补标记/清除算法当中，内存区域分散的缺点，也消除了复制算法当中，内存减半的高额代价。

**缺点**

标记/整理算法唯一的缺点就是效率也不高，不仅要标记所有存活对象，还要整理所有存活对象的引用地址。
从效率上来说，标记/整理算法要低于复制算法。

**标记清除压缩(Mark-Sweep-Compact)**

![image-20200407220604260](E:\dev\javaweb\IDEA\javaExercise\images\old3)

##### 4.2.2 小结

Compact阶段的开销与存活对像的数据成开比，如上一条所描述，对于大量对像的移动是很大开销的，做为老年代的第一选择并不合适。

基于上面的考虑，老年代一般是由标记清除或者是标记清除与标记整理的混合实现。以hotspot中的CMS回收器为例，CMS是基于Mark-Sweep实现的，对于对象的回收效率很高，而对于碎片问题，CMS采用基于Mark-Compact算法的Serial Old回收器做为补偿措施：当内存回收不佳（碎片导致的Concurrent Mode Failure时），将采用Serial Old执行Full GC以达到对老年代内存的整理。

##### 4.2.3 GC面试题

1. StackOverFlowError和OutOfMemoryError，谈谈你的理解

2. 一般什么时候会发生GC？如何处理？

   答：Java中的GC回有两种回收：年轻带的MinorGC，老年代的FullGC；新对象创建时如果伊甸园空间不足会触发MinorGC，如果此时老年代的内存空间不足会触发FullGC，如果空间都不足抛出OutOfMemoryError。

3. GC回收策略，谈谈你的理解

   答：年轻代（伊甸园区+两个幸存区），GC回收策略为“复制”；老年区的保存空间一般比较大，GC回收策略
   为“整理压缩”。

4. GC是什么？

   答：频繁收集Young区，较少收集Old区，基本不动Perm区

5. JVM内存模型以及分区，需要详细到每个区放什么

6. 堆里面的分区：Eden,suirival from to,老年代，各自特点

7. GC的三种收集方法：标记清除、标记整理、复制算法的原理特点

8. MinorGC和Full GC分别在什么时候发生



-----

##  三、面试题

### 一、JUC多线程及并发包

#### 1、谈谈你对volatile的理解？

答：①volatile是java虚拟机提供的轻量级的同步机制，包括三个特性：保证可见性，不保证原子性，禁止指令重排

② JMM你谈谈？

答：JMM（java内存模型）并不是真实存在。JMM关于同步规定：

- 线程解锁前，必须把共享变量的值刷新回主内存
- 线程加锁前，必须读取主内存的最新值到自己的工作内存
- 加索解锁是同一把锁

```
由于JVM运行程序的实体是线程,而每个线程创建时JVM都会为其创建一个工作内存(有些地方成为栈空间),工作内存是每个线程的私有数据区域,而Java内存模型中规定所有变量都存储在主内存,主内存是共享内存区域,所有线程都可访问,但线程对变量的操作(读取赋值等)必须在工作内存中进行,首先要将变量从主内存拷贝到自己的工作空间,然后对变量进行操作,操作完成再将变量写回主内存,不能直接操作主内存中的变量,各个线程中的工作内存储存着主内存中的变量副本拷贝,因此不同的线程无法访问对方的工作内存,此案成间的通讯(传值) 必须通过主内存来完成,
```

**可见性**：A线程在自己栈空间修改了主内存中某个共享变量，还未写回主内存中，此时另一线程B也在自己的栈空间修改了主内存中某个变量，但此时A线程工作内存中的那个共享变量对B线程来说并不可见，这就会因为延迟现象导致可见性问题。

**原子性**：不保证原子性，  要保证同步可以加synchronization

**有序性**：计算机在执行程序时,为了提高性能,编译器和处理器常常会做指令重排。又分为单线程和多线程，其中单线程里面确保程序最终执行结果和代码顺序执行的结果一致，处理起在进行重排序是必须要考虑指令之间的数据依赖性；多线程中线程交替执行，由于编译器优化重排的存在，两个线程使用的变量能否保持一致性是无法确定的，结果无法预测。

③ 在哪些地方用过volatile？

答：单例模式，代理模式

```
public class SingletonDemo {

    private static volatile SingletonDemo instance=null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 构造方法");
    }

    /**
     * 双重检测机制
     * @return
     */
    public static SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <=10; i++) {
            new Thread(() ->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
 
```

解释如下：

```
DCL(双端检锁) 机制不一定线程安全,原因是有指令重排的存在,加入volatile可以禁止指令重排
原因在于某一个线程在执行到第一次检测,读取到的instance不为null时,instance的引用对象可能没有完成初始化.
instance=new SingletonDem(); 可以分为以下步骤(伪代码)
 
memory=allocate();//1.分配对象内存空间
instance(memory);//2.初始化对象
instance=memory;//3.设置instance的指向刚分配的内存地址,此时instance!=null 
 
步骤2和步骤3不存在数据依赖关系.而且无论重排前还是重排后程序执行的结果在单线程中并没有改变,因此这种重排优化是允许的.
memory=allocate();//1.分配对象内存空间
instance=memory;//3.设置instance的指向刚分配的内存地址,此时instance!=null 但对象还没有初始化完.
instance(memory);//2.初始化对象
但是指令重排只会保证串行语义的执行一致性(单线程) 并不会关心多线程间的语义一致性
所以当一条线程访问instance不为null时,由于instance实例未必完成初始化,也就造成了线程安全问题.
```

#### 2、CAS知道吗？

- 比较并交换
- CAS底层原理？ 如果知道，谈谈你对UnSafe的理解
- CAS缺点

##### 2.1 比较并交换

```
CAS的全称为Compare-And-Swap ,它是一条CPU并发原语.
它的功能是判断内存某个位置的值是否为预期值,如果是则更新为新的值,这个过程是原子的.
 
CAS并发原语体现在Java语言中就是sun.miscUnSaffe类中的各个方法.调用UnSafe类中的CAS方法,JVM会帮我实现CAS汇编指令.这是一种完全依赖于硬件功能,通过它实现了原子操作,再次强调,由于CAS是一种系统原语,原语属于操作系统用于范畴,是由若干条指令组成,用于完成某个功能的一个过程,并且原语的执行必须是连续的,在执行过程中不允许中断,也即是说CAS是一条原子指令,不会造成所谓的数据不一致的问题.
```

![image-20200401221135255](E:\dev\javaweb\IDEA\javaExercise\images\CAS_AtomicInteger.png)

![image-20200401221247431](E:\dev\javaweb\IDEA\javaExercise\images\CAS_Unsafe1.png)

![image-20200401221333371](E:\dev\javaweb\IDEA\javaExercise\images\CAS_Unsafe2.png)

```java
// compareAndSet(except,update): 如果期望值与原来读取的值相同就update 返回true，否则，不update，返回false
public class ABADemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);   // 初始化值为5
        System.out.println(atomicInteger.compareAndSet(5,2019) + "\t current " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,2020) + "\t current " + atomicInteger.get());
    }
}
```

##### 2.2 CAS底层原理

###### 2.2.1  atomicinteger

  ```
  atomicInteger.getAndIncrement()方法的源代码:
  /**
   * Atomically increments by one the current value.
   *
   * @return the previous value
   */
  public final int getAndIncrement() {
      return unsafe.getAndAddInt(this, valueOffset, 1);
  }
  印出来一个问题:UnSafe类是什么?
  
  ```

  

###### 2.2.2 UnSafe 

1.UnSafe

![image-20200401220531347](E:\dev\javaweb\IDEA\javaExercise\images\CAS_UnSafe.png) 

是CAS的核心类 由于Java 方法无法直接访问底层 ,需要通过本地(native)方法来访问,UnSafe相当于一个后面,基于该类可以直接操作特额定的内存数据.UnSafe类在于sun.misc包中,其内部方法操作可以向C的指针一样直接操作内存,因为Java中CAS操作的实现依赖于UNSafe类的方法.
注意UnSafe类中所有的方法都是native修饰的,也就是说UnSafe类中的方法都是直接调用操作底层资源执行响应的任务

 2.变量ValueOffset,便是该变量在内存中的偏移地址,因为UnSafe就是根据内存偏移地址获取数据的。

```java
  public final int getAndIncrement() {
      return unsafe.getAndAddInt(this, valueOffset, 1);
  }
```

##### 2.3 CAS缺点

- 循环时间长开销很大

  ```
  我们可以看到getAndInt方法执行时，有个do while
  // unsafe.getAndAddInt
  public final int getAndAddInt(Object var1, long var2, int var4){
  	int var5;
  	do{
  		var5 = this.getIntVolatile(var1, var2);
  	} while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
  }
  如果CAS失败，会一直尝试。如果CAS长时间一直不成功，可能会给CPU带来很大的开销
  ```

- 只能保证一个共享变量的原子性

  > 当对一个共享变量执行操作时，我们可以使用循环CAS的方式保证原子性，但是对多个共享变量操作时，循环CAS就无法保证操作的原子性，这个时候就可以用锁来保证原子性

- 印出来ABA问题？？？  详见代码

  > 所谓的ABA问题，就是A线程要执行的程序被B操作了（最后又改为原始值），A却不知道
  >
  > 使用atomicStampedReference解决

  ABADemo2.java

  ```java
  public class ABADemo2 {
      static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
      static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
  
      public static void main(String[] args){
          System.out.println("============以下是ABA问题的产生==============");
          new Thread(()->{
              // 更改后在改回来
              atomicReference.compareAndSet(100,101);
              atomicReference.compareAndSet(101,100);
          },"Thread 1 ").start();
  
          new Thread(()->{
              // 保证线程1完成一次ABA操作
              try {
                  TimeUnit.SECONDS.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(atomicReference.compareAndSet(100,2020) + "\t " + atomicReference.get());
          }, "Thread 2 ").start();
  
          try {
              TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("==========以下是ABA问题的解决==============");
  
          new Thread(()->{
              int stamp = atomicStampedReference.getStamp();
              System.out.println(Thread.currentThread().getName() + "\t第1次版本号" + stamp);
              try {
                  TimeUnit.SECONDS.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
              System.out.println(Thread.currentThread().getName() + "\t第2次版本号" + atomicStampedReference.getStamp());
              atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
              System.out.println(Thread.currentThread().getName() + "\t第3次版本号" + atomicStampedReference.getStamp());
          },"Thread 3").start();
          new Thread(() -> {
              int stamp = atomicStampedReference.getStamp();
              System.out.println(Thread.currentThread().getName() + "\t第1次版本号" + stamp);
              try {
                  TimeUnit.SECONDS.sleep(4);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
  
              System.out.println(Thread.currentThread().getName() + "\t修改是否成功" + result + "\t当前最新实际版本号：" + atomicStampedReference.getStamp());
              System.out.println(Thread.currentThread().getName() + "\t当前最新实际值：" + atomicStampedReference.getReference());
          }, "Thread 4").start();
      }
  
  }
  ```

#### 3、原子类AtomicInteger的ABA问题谈谈，原子类更新知道吗？

1. ABA问题的产生

   CAS会导致“ABA问题”。CAS算法实现一个重要前提需要取出内存中某时刻的数据并在当下时刻比较并替换，那么在这个时间差类会导致数据的变化。比如说一个线程one从内存位置V中取出A，这时候另一个线程two也从内存中取出A，并且线程two进行了一些操作将值变成了B，然后线程two有i昂V位置的数据变成A，这时候线程one进行CAS操作发现内存中仍然是A，然后线程one操作成功。

   尽管线程one的CAS操作成功，但是不代表这个过程就是没有问题的。

2. 原子引用

   ```java
   public class AtomicReferenceDemo {
       public static void main(String[] args) {
           User user1 = new User("张三", 22);
           User user2 = new User("李四", 23);
           AtomicReference<User> atomicReference = new AtomicReference<>();
           // 对user1 操作  原来的为user1  被改为user2   最后一条语句  期望user1  但是现在已经是user2
           atomicReference.set(user1);
           System.out.println(atomicReference.compareAndSet(user1, user2) + "\t" + atomicReference.get().toString());//true	juc.cas.User@14ae5a5
           System.out.println(atomicReference.compareAndSet(user1, user2) + "\t" + atomicReference.get().toString());//false	juc.cas.User@14ae5a5
       }
   }
   ```

3. 时间戳原子引用

   参考上面ABADemo.java。主要使用了AtomicStampedReference

   比如：

   ```java
   atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
   ```



#### 4、ArrayList线程问题

我们知道ArrayList是线程不安全,请编写一个不安全的案例并给出解决方案

造成的原因代码：

```
/**
     * 故障现象
     * java.util.ConcurrentModificationException
     */
    public static void notSafe(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                // UUID(Universally Unique Identifier)全局唯一标识符,是指在一台机器上生成的数字，
                // 它保证对在同一时空中的所有机器都是唯一的，是由一个十六位的数字组成,表现出来的形式
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
```

解决方法：

```
	// 解决方案1： 使用Vector
    public static void vectorTest(){
        List<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    // 解决方案2：使用Collections辅助类
    public static void collectionsTest(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    //解决方案3  CopyOnWriteArrayList
    public static void copyOnWriteArrayListTest(){
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }
```

限制不可以使用vector和Collections工具类的时候，推荐使用CopyOnWriteArrayList

注意：集合中三种copyOnWrite方法

- List线程copyOnWriteArrayList
- set线程CopyOnwriteHashSet
- map线程ConcurrentHashMap

#### 5、处理并发常见的锁

公平锁/非公平锁/可重入锁/递归锁/自旋锁谈谈你的理解?请手写一个自旋锁

1）公平锁/非公平锁

  - 公平锁
    是指多个线程按照申请锁的顺序来获取锁类似排队打饭 先来后到

  - 非公平锁

    是指在多线程获取锁的顺序并不是按照申请锁的顺序,有可能后申请的线程比先申请的线程优先获取到锁,在高并发的情况下,有可能造成优先级反转或者饥饿现象

* 公平锁/非公平锁
    并发包ReentrantLock的创建可以指定构造函数的boolean类型来得到公平锁或者非公平锁 默认是非公平锁

![image-20200402013538035](E:\dev\javaweb\IDEA\javaExercise\images\Lock1.png)

Java ReentrantLock而言,通过构造哈数指定该锁是否是公平锁 默认是非公平锁。 非公平锁的优点在于吞吐量比公平锁大.


对于synchronized而言 也是一种非公平锁.

2）可重入锁（又名递归锁）

- 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。

  也就是说，线程可以进入任何一个他已经拥有的锁所同步着的代码块

- ReentrantLock/synchronized就是一个典型的可重入锁

- 可重复锁最大的作用就是可以避免死锁！

ReenterLockDemo代码如下：

```

```

