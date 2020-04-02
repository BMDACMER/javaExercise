记录java学习中零碎知识点

-----

###  JUC多线程及并发包

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

