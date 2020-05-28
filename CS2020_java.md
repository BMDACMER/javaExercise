## 一、JUC 

### 1 JUC是什么

java.util.concurrent在并发编程中使用的工具类。

![image-20200408220716211](E:\dev\javaweb\IDEA\javaExercise\images\juc1.png)

### 2 进程/线程

**进程**：进程是一个具有一定独立功能的程序关于某个数据集合的一次运行活动。它是操作系统动态执行的基本单元，在传统的操作系统中，进程既是基本的分配单元，也是基本的执行单元。

**线程**：通常在一个进程中可以包含若干个线程，当然一个进程中至少有一个线程，不然没有存在的意义。线程可以利用进程所拥有的资源，在引入线程的操作系统中，通常都是把进程作为分配资源的基本单位，而把线程作为独立运行和独立调度的基本单位，由于线程比进程更小，基本上不拥有系统资源，故对它的调度所付出的开销就会小得多，能更高效的提高系统多个程序间并发执行的程度。

**例子**：使用QQ，查看进程一定有一个QQ.exe的进程，我可以用qq和A文字聊天，和B视频聊天，给C传文件，给D发一段语言，QQ支持录入信息的搜索。

大四的时候写论文，用word写论文，同时用QQ音乐放音乐，同时用QQ聊天，多个进程。

word如没有保存，停电关机，再通电后打开word可以恢复之前未保存的文档，word也会检查你的拼写，两个线程：容灾备份，语法检查

**线程状态**：NEW,(新建)， RUNNABLE,（准备就绪），  BLOCKED,（阻塞），WAITING,（不见不散），TIMED_WAITING,（过时不候），  TERMINATED;(终结)。

**wait/sleep功能都是当前线程暂停，有什么区别？**
wait放开手去睡，放开手里的锁
sleep握紧手去睡，醒了手里还有锁

**什么是并发？高并发？什么是并行？**

并发：同一时刻多个线程在访问同一个资源，多个线程对一个点
           例子：小米9今天上午10点，限量抢购
                      春运抢票
						电商秒杀...

高并发：服务能同时处理很多请求，提高程序性能

并行：多项工作一起执行，之后再汇总
          例子：泡方便面，电水壶烧水，一边撕调料倒入桶中

### 3 Lock接口

#### 3.1 复习Synchronized 

**多线程编程模板上**

- 线程 操作 资源类
- 高内聚低耦合

**实现步骤**

1. 创建资源类
2. 资源类里创建同步方法、同步代码块

实例：买票程序

#### 3.2 Lock

锁实现提供了比使用同步方法和语句可以获得的更广泛的锁操作。它们允许更灵活的结构，可能具有非常不同的属性，并且可能支持多个关联的条件对象。在java.util.current.locks包中。

Lock接口的实现/ReentrantLock可重入锁

```java
class X {
   private final ReentrantLock lock = new ReentrantLock();
   // ...
 
   public void m() {
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
   }
 }
```

##### 3.2.1 synchronized与Lock的区别 

1.首先synchronized是java内置关键字，在jvm层面，Lock是个java类；
2.synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁；
3.synchronized会自动释放锁(a 线程执行完同步代码会释放锁 ；b 线程执行过程中发生异常会释放锁)，Lock需在finally中手工释放锁（unlock()方法释放锁），否则容易造成线程死锁；
4.用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，线程2线程等待。如果线程1阻塞，线程2则会一直等待下去，而Lock锁就不一定会等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了；
5.synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平（两者皆可）
6.Lock锁适合大量同步的代码的同步问题，synchronized锁适合代码少量的同步问题。

##### 3.2.2 创建线程方式

方式一：继承Thread类的方式：
* 1. 创建一个继承于Thread类的子类
* 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
* 3. 创建Thread类的子类的对象
* 4. 通过此对象调用start()：作用 ①启动当前线程 ② 调用当前线程的run()

说明两个问题：
问题一：我们启动一个线程，必须调用start()，不能调用run()的方式启动线程。
问题二：如果再启动一个线程，必须重新创建一个Thread子类的对象，调用此对象的start().

例如：public class SaleTicket extends Thread

​           java是单继承，资源宝贵，要用接口方式，`不能这么写`

方式二：实现Runnable接口的方式：
* 1. 创建一个实现了Runnable接口的类
* 2. 实现类去实现Runnable中的抽象方法：run()
* 3. 创建实现类的对象
* 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
* 5. 通过Thread类的对象调用start()

两种方式的对比：
* 开发中：优先选择：实现Runnable接口的方式
* 原因：1. 实现的方式没类的单继承性的局限性
* 2. 实现的方式更适合来处理多个线程共享数据的情况。
* 联系：public class Thread implements Runnable
* 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
                     目前两种方式，要想启动线程，都是调用的Thread类中的start()。



![image-20200409090005528](E:\dev\javaweb\IDEA\javaExercise\images\Thread)

##### 3.2.3 实现runnable方法

- 新建类实现runnable接口

  - class MyThread implements Runnable  //新建类实现runnable接口

    new Thread(new MyThread, ...) 这种方法会新增类，有更好的方法

- 匿名内部类

  ```java
  new Thread(new Runnable() {
      @Override
      public void run() {
   
      }
     }, "your thread name").start();
   
   这种方法不需要创建新的类，可以new接口
  
  ```

- lambda表达式

  ```java
  new Thread(() -> {
   
   }, "your thread name").start();
   
  这种方法代码更简洁精炼
  ```

实例：

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
class Ticket //实例例eld +method
{
 private int number=30;
/* //1同步 public synchronized void sale() 
 {//2同步  synchronized(this) {}
  if(number > 0) {
    System.out.println(Thread.currentThread().getName()+"卖出"+(number--)+"\t 还剩number);
   }
 }*/
 
// Lock implementations provide more extensive locking operations
// than can be obtained using synchronized methods and statements. 
 private Lock lock = new ReentrantLock();//List list = new ArrayList()
 
 public void sale() 
 {
   lock.lock();
   
   try {
    if(number > 0) {
     System.out.println(Thread.currentThread().getName()+"卖出"+(number--)+"\t 还剩number);
    }
   } catch (Exception e) {
    e.printStackTrace();
   } finally {
    lock.unlock();
   }
   
 }
 
}
 
 
/**
 * @Description:卖票程序个售票出  0张票
 */
public class SaleTicket 
{
 public static void main(String[] args)//main所有程序
   Ticket ticket = new Ticket();
   //Thread(Runnable target, String name) Allocates a new Thread object.
    
 new Thread(() -> {for (int i = 1; i < 40; i++)ticket.sale();}, "AA").start();
 new Thread(() -> {for (int i = 1; i < 40; i++)ticket.sale();}, "BB").start();
 new Thread(() -> {for (int i = 1; i < 40; i++)ticket.sale();}, "CC").start();
 
/*  new Thread(new Runnable() {
    @Override
    public void run() 
    {
     for (int i = 1; i <=40; i++) 
     {
       
       ticket.sale();
     }
    }
   }, "AA").start();
   
   new Thread(new Runnable() {
    @Override
    public void run() 
    {
     for (int i = 1; i <=40; i++) 
     {
       ticket.sale();
     }
    }
   }, "BB").start();
   new Thread(new Runnable() {
    @Override
    public void run() 
    {
     for (int i = 1; i <=40; i++) 
     {
       ticket.sale();
     }
    }
   }, "CC").start();
   */
 }
}
 
```

### 4 lambda表达式

Lambda表达式是一个匿名函数，可以把Lambda表达式理解为一段可以传递的代码（将代码像数据一样进行传递）。可以写出更简洁、更灵活的代码。作为一种紧凑的代码风格，使java的语言表达能力得到了提升。

Lambda表达式在java语言中引入了一个新的语法元素和操作符。这个操作符为"->"，该操作符被称为Lambda操作符或箭头操作符。它将Lambda分为两个部分：

左侧：制定了Lambda表达式需要的所有参数

右侧：指定了Lambda体，即Lambda表达式要执行的功能。

```java
import java.util.ArrayList;

/**
 * 1 函数式编程
 * 2 @FunctionalInterface------要求只有一个接口
 * 3 default
 * 4 static
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        // 接口可以创建对象
//        Foo foo = new Foo(){
//            @Override
//            public void sayHello() {
//                System.out.println("*********hello123");
//            }
//        };
//        foo.sayHello();

        Foo foo1 = (int x, int y) -> {
            return x + y;
        };
        System.out.println(foo1.add(1, 2));
        System.out.println(foo1.mul(3,5));
        System.out.println(Foo.mul2(5,6));
    }
}

interface Foo{
//    public abstract void sayHello();
    public int add(int a, int b);
    // 可以有多个默认方法
    public default  int mul(int x, int y) {
        return x * y;
    }
    // 可以定义多个静态方法
    public static int mul2(int x, int y) {
        return x * y;
    }

    public static void main1(String[] args) {
        ArrayList arrayList = new ArrayList();
    }
}
```

注释：lambda表达式，如果一个接口只有一个方法，我可以把方法名省略
           Foo foo = () -> {System.out.println("****hello lambda");};

​			接口中可以有实现方法：default方法（可以有多个），静态方法（可以有多个）。

​           写法：拷贝小括号（），写死右箭头->，落地大括号{...}

**函数式接口**： lambda表达式必须是函数式接口，必须只有一个方法。如果接口只有一个方法java默认它为函数式接口。为正确使用lambda表达式，需要给接口加个注解：`@FunctionalInterface`   如果有两个方法，立刻报错

### 5 线程间通信

案例：生产者+消费者   通知等待唤醒机制

**多线程编程模板**

> 1、判断     2、干活    3、通知
>
> 注意：多线程之间的虚假唤醒

#### 5.1 全通知通信

**synchronized与Condition实现**

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 
class ShareDataOne//资源类
{
  private int number = 0;//初始值为零的一个变量
 
  public synchronized void increment() throws InterruptedException 
  {
     //1判断
     if(number !=0 ) {    // 需要换程while 防止虚假唤醒
       this.wait();
     }
     //2干活
     ++number;
     System.out.println(Thread.currentThread().getName()+"\t"+number);
     //3通知
     this.notifyAll();
  }
  
  public synchronized void decrement() throws InterruptedException 
  {
     // 1判断
     if (number == 0) {   // 需要换程while 防止虚假唤醒
       this.wait();
     }
     // 2干活
     --number;
     System.out.println(Thread.currentThread().getName() + "\t" + number);
     // 3通知
     this.notifyAll();
  }
}
 
/**
 * 
 * @Description:
 *现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮。 
 *
 *  * 笔记：Java里面如何进行工程级别的多线程编写
 * 1 多线程变成模板（套路）-----上
 *     1.1  线程    操作    资源类  
 *     1.2  高内聚  低耦合
 * 2 多线程变成模板（套路）-----下
 *     2.1  判断
 *     2.2  干活
 *     2.3  通知
 */
public class NotifyWaitDemoOne
{
  public static void main(String[] args)
  {
  	// 资源类 
     ShareDataOne sd = new ShareDataOne();
     // 线程
     new Thread(() -> {
       for (int i = 1; i < 10; i++) {
          try {
          	// 操作
            sd.increment();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
       }
     }, "A").start();
     new Thread(() -> {
       for (int i = 1; i < 10; i++) {
          try {
            sd.decrement();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
       }
     }, "B").start();
  }
}
```

上述4个线程（或者更多）或导致错误，出现`虚假唤醒`。

原因：在java多线程判断时，不能使用if，程序出事就发生在判断语句。比如： 突然有一添加的此案成进到了if里，这时突然中断了交出控制权，没有进行验证，而是直接走下去，这就导致if里的代码块执行了两次（甚至多次）。

解决办法：查看API   java.lang.Object

![image-20200409094046631](E:\dev\javaweb\IDEA\javaExercise\images\thread2)

中断和虚假唤醒是可能产生的，所以要用loop循环，if只能判断一次，while是只要唤醒就要拉回来在判断一次。if换成while即可解决！

**jdk8新实现**

![image-20200409094419978](E:\dev\javaweb\IDEA\javaExercise\images\thread2.png)

![image-20200409094442505](E:\dev\javaweb\IDEA\javaExercise\images\thread3)

使用Collection：查看API    java.util.concurrent

```java
class BoundedBuffer {
   final Lock lock = new ReentrantLock();
   final Condition notFull  = lock.newCondition(); 
   final Condition notEmpty = lock.newCondition(); 
 
   final Object[] items = new Object[100];
   int putptr, takeptr, count;
 
   public void put(Object x) throws InterruptedException {
     lock.lock();
     try {
       while (count == items.length)
         notFull.await();
       items[putptr] = x;
       if (++putptr == items.length) putptr = 0;
       ++count;
       notEmpty.signal();
     } finally {
       lock.unlock();
     }
   }
```

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
import org.omg.IOP.Codec;
 
 
class ShareData//资源类
{
  private int number = 0;//初始值为零的一个变量
 
  private Lock lock = new ReentrantLock();
  private Condition condition  = lock.newCondition(); 
   
  public  void increment() throws InterruptedException 
  {
     
      lock.lock();
         try {
          //判断
          while(number!=0) {
            condition.await();
          }
          //干活
          ++number;
          System.out.println(Thread.currentThread().getName()+" \t "+number);
          //通知
          condition.signalAll();
     } catch (Exception e) {
       e.printStackTrace();
     } finally {
       lock.unlock();
     }
     
  }
  
  
  public  void decrement() throws InterruptedException 
  {
      
      lock.lock();
         try {
          //判断
          while(number!=1) {
            condition.await();
          }
          //干活
          --number;
          System.out.println(Thread.currentThread().getName()+" \t "+number);
          //通知
          condition.signalAll();
     } catch (Exception e) {
       e.printStackTrace();
     } finally {
       lock.unlock();
     }
     
  }
  
  /*public synchronized void increment() throws InterruptedException 
  {
     //判断
     while(number!=0) {
       this.wait();
     }
     //干活
     ++number;
     System.out.println(Thread.currentThread().getName()+" \t "+number);
     //通知
     this.notifyAll();;
  }
  
  public synchronized void decrement() throws InterruptedException 
  {
     //判断
     while(number!=1) {
       this.wait();
     }
     //干活
     --number;
     System.out.println(Thread.currentThread().getName()+" \t "+number);
     //通知
     this.notifyAll();
  }*/
}
 
/**
 * 
 * @Description:
 *现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮。 
 * 
 */
public class NotifyWaitDemo
{
  public static void main(String[] args)
  {
     ShareData sd = new ShareData();
     new Thread(() -> {
 
       for (int i = 1; i <= 10; i++) {
          try {
            sd.increment();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
       }
     }, "A").start();
     
     new Thread(() -> {
 
       for (int i = 1; i <= 10; i++) {
          try {
            sd.decrement();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
       }
     }, "B").start();
     new Thread(() -> {
 
       for (int i = 1; i <= 10; i++) {
          try {
            sd.increment();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
       }
     }, "C").start();
     new Thread(() -> {
 
       for (int i = 1; i <= 10; i++) {
          try {
            sd.decrement();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
       }
     }, "D").start();
     
  }
}
```

#### 5.2 线程间定制化调用通信

重温：多线程编写代码模板   ----->   线程-调用-资源类      判断-干活-通知（采用while）

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
class ShareResource
{
  private int number = 1;//1:A 2:B 3:C 
  private Lock lock = new ReentrantLock();
  private Condition c1 = lock.newCondition();
  private Condition c2 = lock.newCondition();
  private Condition c3 = lock.newCondition();
 
  public void print5(int totalLoopNumber)
  {
     lock.lock();
     try 
     {
       //1 判断
       while(number != 1)
       {
          //A 就要停止
          c1.await();
       }
       //2 干活
       for (int i = 1; i <=5; i++) 
       {
          System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
       }
       //3 通知
       number = 2;
       c2.signal();
     } catch (Exception e) {
       e.printStackTrace();
     } finally {
       lock.unlock();
     }
  }
  public void print10(int totalLoopNumber)
  {
     lock.lock();
     try 
     {
       //1 判断
       while(number != 2)
       {
          //A 就要停止
          c2.await();
       }
       //2 干活
       for (int i = 1; i <=10; i++) 
       {
          System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
       }
       //3 通知
       number = 3;
       c3.signal();
     } catch (Exception e) {
       e.printStackTrace();
     } finally {
       lock.unlock();
     }
  }  
  
  public void print15(int totalLoopNumber)
  {
     lock.lock();
     try 
     {
       //1 判断
       while(number != 3)
       {
          //A 就要停止
          c3.await();
       }
       //2 干活
       for (int i = 1; i <=15; i++) 
       {
          System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
       }
       //3 通知
       number = 1;
       c1.signal();
     } catch (Exception e) {
       e.printStackTrace();
     } finally {
       lock.unlock();
     }
  }  
}
 
 
/**
 * 
 * @Description: 
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 * 
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮  
 *
 */
public class ThreadOrderAccess
{
  public static void main(String[] args)
  {
     ShareResource sr = new ShareResource();
     
     new Thread(() -> {
       for (int i = 1; i <=10; i++) 
       {
          sr.print5(i);
       }
     }, "AA").start();
     new Thread(() -> {
       for (int i = 1; i <=10; i++) 
       {
          sr.print10(i);
       }
     }, "BB").start();
     new Thread(() -> {
       for (int i = 1; i <=10; i++) 
       {
          sr.print15(i);
       }
     }, "CC").start();   
        
  }
}
```

### 6 多线程锁

还是以例子理解

```java
import java.util.concurrent.TimeUnit;
 
class Phone
{
 public  synchronized void sendSMS() throws Exception
 {
   
   System.out.println("------sendSMS");
 }
 public synchronized void sendEmail() throws Exception
 {
   System.out.println("------sendEmail");
 }
 
 public void getHello() 
 {
   System.out.println("------getHello");
 }
 
}
 
/**
 * 
 * @Description: 8锁
 * 
 1 标准访问，先打印短信还是邮件
 2 停4秒在短信方法内，先打印短信还是邮件
 3 新增普通的hello方法，是先打短信还是hello
 4 现在有两部手机，先打印短信还是邮件
 5 两个静态同步方法，1部手机，先打印短信还是邮件
 6 两个静态同步方法，2部手机，先打印短信还是邮件
 7 1个静态同步方法,1个普通同步方法，1部手机，先打印短信还是邮件
 8 1个静态同步方法,1个普通同步方法，2部手机，先打印短信还是邮件
 * ---------------------------------
 * 
 */
public class Lock_8
{
 public static void main(String[] args) throws Exception
 {
 
   Phone phone = new Phone();
   Phone phone2 = new Phone();
   
   new Thread(() -> {
    try {
     phone.sendSMS();
    } catch (Exception e) {
     e.printStackTrace();
    }
   }, "AA").start();
   
   Thread.sleep(100);
   
   new Thread(() -> {
    try {
     phone.sendEmail();
     //phone.getHello();
     //phone2.sendEmail();
    } catch (Exception e) {
     e.printStackTrace();
    }
   }, "BB").start();
 }
}
```

运行答案：

|  1   |  2   |   3   |  4   |  5   |  6   |  7   |  8   |
| :--: | :--: | :---: | :--: | :--: | :--: | :--: | :--: |
| 短信 | 短信 | Hello | 邮件 | 短信 | 短信 | 邮件 | 邮件 |

分析：

 一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，其它的线程都只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法。
锁的是当前对象this，被锁定后，其它的线程都不能进入到当前对象的其它的synchronized方法。

加个普通方法后发现和同步锁无关，换成两个对象后，不是同一把锁了，情况立刻变化。

synchronized实现同步的基础：Java中的每一个对象都可以作为锁。具体表现为以下3种形式：
1）对于普通同步方法，锁是当前实例对象。
2）对于静态同步方法，锁是当前类的Class对象。
3）对于同步方法块，锁是Synchonized括号里配置的对象

当一个线程试图访问同步代码块时，它首先必须得到锁，退出或抛出异常时必须释放锁。也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，
可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁。

所有的静态同步方法用的也是同一把锁——类对象本身，这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间是不会有竞态条件的。但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间。

 

### 7 非安全集合

ArrayList在迭代的时候如果同时对其进行修改就会抛出java.util.ConcurrentModificationException异常（并发修改异常）。

```java
List<String> list = new ArrayList<>();
for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
 
看ArrayList的源码
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
没有synchronized线程不安全
```

**解决方案**

1) Vector

```java
List<String> list = new Vector<>();

看Vector的源码
public synchronized boolean add(E e) {
    modCount++;
    ensureCapacityHelper(elementCount + 1);
    elementData[elementCount++] = e;
    return true;
}
有synchronized线程安全
```

![image-20200409104721914](E:\dev\javaweb\IDEA\javaExercise\images\vector)

2) Collections

List<String> list = Collections.synchronizedList(new ArrayList<>());
Collections提供了方法synchronizedList保证list是同步线程安全的

那HashMap，HashSet是线程安全的吗？也不是
所以有同样的线程安全方法

![image-20200409105114618](E:\dev\javaweb\IDEA\javaExercise\images\collections)

3) **写时复制**

List<String> list = new CopyOnWriteArrayList<>();     CopyOnWriteArrayList是arraylist的一种线程安全变体，
其中所有可变操作（add、set等）都是通过生成底层数组的新副本来实现的。

不加锁性能提升但会出错，加锁数据一致但性能下降

![image-20200409105440086](E:\dev\javaweb\IDEA\javaExercise\images\lockCopy)

```java
 /**
 * Appends the specified element to the end of this list.
 *
 * @param e element to be appended to this list
 * @return {@code true} (as specified by {@link Collection#add})
 */
public boolean add(E e) {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        Object[] elements = getArray();
        int len = elements.length;
        Object[] newElements = Arrays.copyOf(elements, len + 1);
        newElements[len] = e;
        setArray(newElements);
        return true;
    } finally {
        lock.unlock();
    }
}
 
 
CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，
而是先将当前容器Object[]进行Copy，复制出一个新的容器Object[] newElements，然后向新的容器Object[] newElements里添加元素。添加元素后，再将原容器的引用指向新的容器setArray(newElements)。
这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
```

**扩展类比**

HashSet

Set<String> set = new HashSet<>();//线程不安全


Set<String> set = new CopyOnWriteArraySet<>();//线程安全

HashSet底层数据结构是什么？---HashMap

但HashSet的add是放一个值，而HashMap是放K、V键值对，HashSet中的值是默认的，存放进去的为key。

```java
/**
 * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
 * default initial capacity (16) and load factor (0.75).
 */
public HashSet() {
    map = new HashMap<>();
}
```

HashMap

Map<String,String> map = new HashMap<>();//线程不安全


Map<String,String> map = new ConcurrentHashMap<>();//线程安全

 ```java
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 请举例说明集合类是不安全的
 */
public class NotSafeDemo {
    public static void main(String[] args) {

        // ConcurrentHashMap
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{                				           		map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    // CopyOnWriteArraySet
    private static void setNoSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    // CopyOnWriteArrayList
    private static void listNoSafe() {
        //List<String> list = Arrays.asList("a","b","c");
        // list.forEach(System.out::println);
        //写时复制
        List<String> list = new CopyOnWriteArrayList<>();
        // new CopyOnWriteArrayList<>();
        //Collections.synchronizedList(new ArrayList<>());
        //new Vector<>();//new ArrayList<>();

        for (int i = 0; i <30 ; i++) {
                    new Thread(()->{
                        list.add(UUID.randomUUID().toString().substring(0,8));
                        System.out.println(list);
                    },String.valueOf(i)).start();
                }
    }

}

    /**
     * 写时复制
     CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，
     而是先将当前容器Object[]进行Copy，复制出一个新的容器Object[] newElements，然后向新的容器Object[] newElements里添加元素。
     添加元素后，再将原容器的引用指向新的容器setArray(newElements)。
     这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
     所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。   
     
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }
     */
 ```

### 8 Callable 接口

#### 8.1 面试题

1、 获取多线程的方法有几种？

答： 传统的是继承thread类和实现runnable接口，java5以后又有实现callable接口和java的线程池获得。

![image-20200409111058607](E:\dev\javaweb\IDEA\javaExercise\images\collable)

这是一个函数式接口，因此可以用作lambda表达式或方法引用的赋值对象。

2、callable接口与runnable接口的区别？

答：（1）是否有返回值 (call有 run没有) （2）是否抛出异常（call有 run没有）  （3）落地方法不一样，一个是call，一个是run

```java
// 创建新类MyThread实现runnable接口
class MyThread implements Runnable{
 @Override
 public void run() {
 
 }
}
// 新类MyThread2实现callable接口
class MyThread2 implements Callable<Integer>{
 @Override
 public Integer call() throws Exception {
  return 200;
   } 
}
```

#### 8.2 怎么使用

直接替换runnable是否可行？ 答： 不可行，因为：thread类的构造方法根本没有Callable

![image-20200409111709361](E:\dev\javaweb\IDEA\javaExercise\images\thread4)

![image-20200409111801838](E:\dev\javaweb\IDEA\javaExercise\images\thread5)

解决方案： java多态，一个类可以实现多个接口！

![image-20200409111925775](E:\dev\javaweb\IDEA\javaExercise\images\thread6)

FutureTask<Integer> ft = new FutureTask<Integer>(new MyThread());
new Thread(ft, "AA").start();

**FutureTask**

未来的任务，用它就干一件事，异步调用。main方法就像一个冰糖葫芦，一个个方法由main穿起来，但解决不了一个问题：正常调用挂起堵塞问题。

![image-20200409112202529](E:\dev\javaweb\IDEA\javaExercise\images\thread7)

例子：
（1）老师上着课，口渴了，去买水不合适，讲课线程继续，我可以单起个线程找班长帮忙买水，
水买回来了放桌上，我需要的时候再去get。
（2）4个同学，A算1+20,B算21+30,C算31*到40,D算41+50，是不是C的计算量有点大啊，
FutureTask单起个线程给C计算，我先汇总ABD，最后等C计算完了再汇总C，拿到最终结果
（3）高考：会做的先做，不会的放在后面做

> 原理
>
> ```html
> 在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，
> 当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。
>  
> 一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。
>  
> 仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞 get 方法。一旦计算完成，就不能再重新开始或取消计算。get方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态，然后会返回结果或者抛出异常。 
>  
> 只计算一次,get方法放到最后
> ```

```java
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}
class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"come in callable");
        return 200;
    }
}


public class CallableDemo {

    public static void main(String[] args) throws Exception {

        //FutureTask<Integer> futureTask = new FutureTask(new MyThread2());
        FutureTask<Integer> futureTask = new FutureTask(()->{
            System.out.println(Thread.currentThread().getName()+"  come in callable");
            TimeUnit.SECONDS.sleep(4);
            return 1024;
        });
        FutureTask<Integer> futureTask2 = new FutureTask(()->{
            System.out.println(Thread.currentThread().getName()+"  come in callable");
            TimeUnit.SECONDS.sleep(4);
            return 2048;
        });

        new Thread(futureTask,"zhang3").start();
        new Thread(futureTask2,"li4").start();

        //System.out.println(futureTask.get());
        //System.out.println(futureTask2.get());
        //1、一般放在程序后面，直接获取结果
        //2、只会计算结果一次

        while(!futureTask.isDone()){
            System.out.println("***wait");
        }
        System.out.println(futureTask.get());
        System.out.println(Thread.currentThread().getName()+" come over");
    }
}
```

### 9 JUC辅助类

- CountDownLatch 减少计数
- CyclicBarrier 循环栅栏
- Semaphore 信号灯

#### 9.1 CountDownLatch 

 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
 * 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 * 当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。

```java
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @Description:
 *让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒。
 * 
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
 * 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 * 当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。
 * 
 * 解释：6个同学陆续离开教室后值班同学才可以关门。
 * 
 * main主线程必须要等前面6个线程完成全部工作后，自己才能开干 
 */
public class CountDownLatchDemo
{
   public static void main(String[] args) throws InterruptedException
   {
       CountDownLatch countDownLatch = new CountDownLatch(6);
       
       for (int i = 1; i <=6; i++) //6个上自习的同学，各自离开教室的时间不一致
       {
          new Thread(() -> {
              System.out.println(Thread.currentThread().getName()+"\t 号同学离开教室");
              countDownLatch.countDown();
          }, String.valueOf(i)).start();
       }
       countDownLatch.await();
       System.out.println(Thread.currentThread().getName()+"\t****** 班长关门走人，main线程是班长");
          
   }
}
```

#### 9.2 CyclicBarrier

CyclicBarrier的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。线程进入屏障通过CyclicBarrier的await()方法。

```java
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
 
/**
 * CyclicBarrier
 * 的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，
 * 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有
 * 被屏障拦截的线程才会继续干活。
 * 线程进入屏障通过CyclicBarrier的await()方法。
 * 
 * 集齐7颗龙珠就可以召唤神龙
 */
public class CyclicBarrierDemo
{
  private static final int NUMBER = 7;
  
  public static void main(String[] args)
  {
     //CyclicBarrier(int parties, Runnable barrierAction) 
     
     CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, ()->{System.out.println("*****集齐7颗龙珠就可以召唤神龙");}) ;
     
     for (int i = 1; i <= 7; i++) {
       new Thread(() -> {
          try {
            System.out.println(Thread.currentThread().getName()+"\t 星龙珠被收集 ");
            cyclicBarrier.await();
          } catch (InterruptedException | BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
       }, String.valueOf(i)).start();
     }   
 
  }
}
```

#### 9.3 Semaphore

在信号量上我们定义两种操作：

1）acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），要么一直等下去，直到有线程释放信号量，或超时。

2）release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。

信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。

```java
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
 
/**
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * 
 * 在信号量上我们定义两种操作：
 * acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），
 *             要么一直等下去，直到有线程释放信号量，或超时。
 * release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。
 * 
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 */
public class SemaphoreDemo
{
  public static void main(String[] args)
  {
     Semaphore semaphore = new Semaphore(3);//模拟3个停车位
     
     for (int i = 1; i <=6; i++) //模拟6部汽车
     {
       new Thread(() -> {
          try 
          {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"\t 抢到了车位");
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            System.out.println(Thread.currentThread().getName()+"\t------- 离开");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }finally {
            semaphore.release();
          }
       }, String.valueOf(i)).start();
     }
     
  }
}
```

### 10 ReentrantReadWriteLock 读写锁

```java
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"\t 正在写"+key);
        //暂停一会儿线程
        try {TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) {e.printStackTrace(); }
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"\t 写完了"+key);
    }

    public Object get(String key){
        Object result = null;
        System.out.println(Thread.currentThread().getName()+"\t 正在读"+key);
        try {TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) {e.printStackTrace(); }
        result = map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t 读完了"+result);
        return result;
    }
}


public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.put(num+"",num+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.get(num+"");
            },String.valueOf(i)).start();
        }

    }
}
```

### 11 BlockingQueue 阻塞队列

栈与队列：栈为FILO（先进后出） 队列为FIFO（先进先出）

#### 11.1 概念

阻塞：必须要阻塞

阻塞队列是一个队列，在数据结构中起的作用如下如所示：

![image-20200409114747996](E:\dev\javaweb\IDEA\javaExercise\images\queue)

当队列为空时，从队列中**获取**元素的操作将会被阻塞；当队列满时，从队列中**添加**的元素将会被阻塞。

试图从空的队列中获取元素的线程将会被阻塞，直到其他线程往空的队列插入新的元素。

试图向已满的队列中添加新元素的线程将会被阻塞，直到其他线程从队列中移除一个或多个元素或者完全清空，使队列变得空闲起来并后续新增。

**好处**

在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤起

为什么需要BlockingQueue？
好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，因为这一切BlockingQueue都给你一手包办了

在concurrent包发布以前，在多线程环境下，我们每个程序员都必须去自己控制这些细节，尤其还要兼顾效率和线程安全，而这会给我们的程序带来不小的复杂度。

#### 11.2 架构及分析

![image-20200409115228983](E:\dev\javaweb\IDEA\javaExercise\images\queue2)

种类分析：

- **ArrayBlockingQueue**：由数组结构组成的有界阻塞队列。
- **LinkedBlockingQueue**：由链表结构组成的有界（但大小默认值为integer.MAX_VALUE）阻塞队列。
- PriorityBlockingQueue：支持优先级排序的无界阻塞队列。
- DelayQueue：使用优先级队列实现的延迟无界阻塞队列。
- **SynchronousQueue**：不存储元素的阻塞队列，也即单个元素的队列。
- LinkedTransferQueue：由链表组成的无界阻塞队列。
- LinkedBlockingDeque：由链表组成的双向阻塞队列。

**BlockingQueue核心方法**

![image-20200409115536304](E:\dev\javaweb\IDEA\javaExercise\images\blockingqueue)

![image-20200409115637500](E:\dev\javaweb\IDEA\javaExercise\images\blockingqueue2)

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

//        List list = new ArrayList();

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //第一组
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.element());

        //System.out.println(blockingQueue.add("x"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//    第二组
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("x"));
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//    第三组        
//         blockingQueue.put("a");
//         blockingQueue.put("b");
//         blockingQueue.put("c");
//         //blockingQueue.put("x");
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
        
//    第四组        
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("a",3L, TimeUnit.SECONDS));

    }
}
```

### 12 ThreadPool 线程池

**为什么要用线程池**

第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的销耗。
第二：提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行。
第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会销耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。

**线程池的优势**：
线程池做的工作只要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行。

它的主要特点为：线程复用;控制最大并发数;管理线程。

**架构说明**

Java中的线程池是通过Executor框架实现的，该框架中用到了`Executor`，`Executors`，`ExecutorService`，`ThreadPoolExecutor`这几个类。

![image-20200409121831956](E:\dev\javaweb\IDEA\javaExercise\images\ThreadPool)

1) Executors.newFixedThreadPool(int)

```java
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
}
 
newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的是LinkedBlockingQueue
```

执行长期任务性能好，创建一个线程池，一池有N个固定的线程，有固定线程数的线程。

2) Executors.newSingleThreadExecutor()

```java
public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}
 
newSingleThreadExecutor 创建的线程池corePoolSize和maximumPoolSize值都是1，它使用的是LinkedBlockingQueue
```

一个任务一个任务的执行，一池一线程

3) Executors.newCachedThreadPool()

```java
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
newCachedThreadPool创建的线程池将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE，它使用的是SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程。
```

执行很多短期异步任务，线程池根据需要创建新线程，但在先前构建的线程可用时将重用它们。可扩容，遇强则强

```java
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * Arrays
 * Collections
 * Executors
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //List list = new ArrayList();
        //List list = Arrays.asList("a","b");
        //固定数的线程池，一池五线程

//       ExecutorService threadPool =  Executors.newFixedThreadPool(5); //一个银行网点，5个受理业务的窗口
//       ExecutorService threadPool =  Executors.newSingleThreadExecutor(); //一个银行网点，1个受理业务的窗口
       ExecutorService threadPool =  Executors.newCachedThreadPool(); //一个银行网点，可扩展受理业务的窗口

        //10个顾客请求
        try {
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
```

**ThreadPoolExecutor 底层原理**

![image-20200409122508820](E:\dev\javaweb\IDEA\javaExercise\images\ThreadPoolExecutor)

![image-20200409122849577](E:\dev\javaweb\IDEA\javaExercise\images\ThreadPoolExecutor1)

![image-20200409122910184](E:\dev\javaweb\IDEA\javaExercise\images\ThreadPoolExecutor2)

1. 在创建了线程池后，开始等待请求。
2. 当调用execute()方法添加一个请求任务时，线程池会做出如下判断：
   - 如果正在运行的线程数量小于corePoolSize，那么马上创建线程运行这个任务；
   - 如果正在运行的线程数量大于或等于corePoolSize，那么将这个任务放入队列；
   - 如果这个时候队列满了且正在运行的线程数量还小于maximumPoolSize，那么还是要创建非核心线程立刻  运行这个任务；
   - 如果队列满了且正在运行的线程数量大于或等于maximumPoolSize，那么线程池会启动饱和拒绝策略来执行。
3. 当一个线程完成任务时，它会从队列中取下一个任务来执行。
4. 当一个线程无事可做超过一定的时间（keepAliveTime）时，线程会判断：
       如果当前运行的线程数大于corePoolSize，那么这个线程就被停掉。
       所以线程池的所有任务完成后，它最终会收缩到corePoolSize的大小。

**线程池重要参数**

- corePoolSize：线程池中的常驻核心线程数
- maximumPoolSize：线程池中能够容纳同时执行的最大线程数，此值必须大于等于1
- keepAliveTime：多余的空闲线程的存活时间当前池中线程数量超过corePoolSize时，当空闲时间
  达到keepAliveTime时，多余线程会被销毁直到只剩下corePoolSize个线程为止
- unit：keepAliveTime的单位 
- workQueue：任务队列，被提交但尚未被执行的任务
- threadFactory：表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认的即可
- handler：拒绝策略，表示当队列满了，并且工作线程大于等于线程池的最大线程数（maximumPoolSize）时如何来拒绝请求执行的runnable的策略

**实践中用哪个**

`线程池的拒绝策略`：等待队列已经排满了，再也塞不下新任务了同时，线程池中的max线程也达到了，无法继续为新任务服务。这个是时候我们就需要拒绝策略机制合理的处理这个问题。

`JDK内置的拒绝策略`：

- AbortPolicy(默认)：直接抛出RejectedExecutionException异常阻止系统正常运行
- CallerRunsPolicy：“调用者运行”一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量。
- DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加人队列中尝试再次提交当前任务。
- DiscardPolicy：该策略默默地丢弃无法处理的任务，不予任何处理也不抛出异常。如果允许任务丢失，这是最好的一种策略。

以上内置拒绝策略均实现了`RejectedExecutionHandle`接口



在工作中单一的/固定数的/可变的三种创建线程池的方法哪个用的多？超级大坑?

答：一个都不用，我们工作中只能使用自定义的。

![image-20200409124038400](E:\dev\javaweb\IDEA\javaExercise\images\ThreadPoolExecutor3)

案例：

```java
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 * Arrays
 * Collections
 * Executors
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        // 使用 ThreadPoolExecutor 创建线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        //10个顾客请求
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

    private static void threadPool() {
        //List list = new ArrayList();
        //List list = Arrays.asList("a","b");
        //固定数的线程池，一池五线程

//       ExecutorService threadPool =  Executors.newFixedThreadPool(5); //一个银行网点，5个受理业务的窗口
//       ExecutorService threadPool =  Executors.newSingleThreadExecutor(); //一个银行网点，1个受理业务的窗口
        ExecutorService threadPool = Executors.newCachedThreadPool(); //一个银行网点，可扩展受理业务的窗口

        //10个顾客请求
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
```

### 13 java8之流式计算

**函数式接口**

![image-20200409124624870](E:\dev\javaweb\IDEA\javaExercise\images\function1)

- ？表示不确定的 java 类型
- T (type) 表示具体的一个java类型
- K V (key value) 分别代表java键值中的Key Value
- E (element) 代表Element

```java
//R apply(T t);函数型接口，一个参数，一个返回值
Function<String,Integer> function = t ->{return t.length();};
System.out.println(function.apply("abcd"));

//boolean test(T t);断定型接口，一个参数，返回boolean
Predicate<String> predicate = t->{return t.startsWith("a");};
System.out.println(predicate.test("a"));

// void accept(T t);消费型接口，一个参数，没有返回值
Consumer<String> consumer = t->{
    System.out.println(t);
};
consumer.accept("javaXXXX");

//T get(); 供给型接口，无参数，有返回值
Supplier<String> supplier =()->{return UUID.randomUUID().toString();};
System.out.println(supplier.get());
```

**Stream**流

是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。“集合讲的是数据，流讲的是计算！”

> 特点
>
> - Stream 自己不会存储元素
> - Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
> - Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。

分为三个阶段（即：源头=>中间流水线=>结果）

1. 创建一个Stream：一个数据源（数组、集合）
2. 中间操作：一个中间操作，处理数据源数据
3. 终止操作：一个终止操作，执行中间操作链，产生结果

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User
{
    private Integer id;
    private String  userName;
    private int     age;
}

/**
 *
 * 题目：请按照给出数据，找出同时满足
 *      偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 *      最后只输出一个用户名字
 */
public class StreamDemo
{
    public static void main(String[] args)
    {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream().filter(p -> {
            return p.getId() % 2 == 0;
        }).filter(p -> {
            return p.getAge() > 24;
        }).map(f -> {
            return f.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);


        //    R apply(T t);
        Function<String,Integer> function = t -> {return t.length();};
        System.out.println(function.apply("abc"));

        // boolean test(T t);
        Predicate<String> predicate = t -> {return t.startsWith("a");};
        System.out.println(predicate.test("a"));

        //void accept(T t);
        Consumer<String> consumer = t -> {System.out.println(t);};
        consumer.accept("java1018");


        //    T get();
        Supplier<String> supplier =  () -> {return UUID.randomUUID().toString();};
        System.out.println(supplier.get());;

    }
}
```

### 14 分支合并框架

Fork：把一个复杂任务进行分拆，大事化小
Join：把分拆任务的结果进行合并

![image-20200409130203666](E:\dev\javaweb\IDEA\javaExercise\images\fork-jion.png)

![image-20200409130246938](E:\dev\javaweb\IDEA\javaExercise\images\fork-jion2)

**相关类**

`ForkJoinPool`:  分支合并池    类比=>   线程池

![](E:\dev\javaweb\IDEA\javaExercise\images\ForkJoinPool)

`ForkJoinTask`: ForkJoinTask    类比=>   FutureTask

![image-20200409130551403](E:\dev\javaweb\IDEA\javaExercise\images\ForkJoinTask)

`RecursiveTask`: 递归任务：继承后可以实现递归(自己调自己)调用的任务

![image-20200409130643102](E:\dev\javaweb\IDEA\javaExercise\images\RecursiveTask)

```java
class Fibonacci extends RecursiveTask<Integer> {
   final int n;
   Fibonacci(int n) { this.n = n; }
   Integer compute() {
     if (n <= 1)
       return n;
     Fibonacci f1 = new Fibonacci(n - 1);
     f1.fork();
     Fibonacci f2 = new Fibonacci(n - 2);
     return f2.compute() + f1.join();
   }
 }
```

**实例**

```java
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer>{
    private static final Integer ADJUST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end - begin)<=ADJUST_VALUE){
           for(int i =begin;i <= end;i++){
                result = result + i;
           }
        }else{
            int middle = (begin + end)/2;
            MyTask task01 = new MyTask(begin,middle);
            MyTask task02 = new MyTask(middle+1,end);
            task01.fork();
            task02.fork();
            result =  task01.join() + task02.join();
        }
        return result;
    }
}


/**
 * 分支合并例子
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyTask myTask = new MyTask(0,100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);

        System.out.println(forkJoinTask.get());

        forkJoinPool.shutdown();
    }
}
```

### 15 异步回调

![image-20200409130909527](E:\dev\javaweb\IDEA\javaExercise\images\Ansync7.png)

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
        //同步，异步，异步回调

        //同步
//        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName()+"\t completableFuture1");
//        });
//        completableFuture1.get();

        //异步回调
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t completableFuture2");
            int i = 10/0;
            return 1024;
        });

        completableFuture2.whenComplete((t,u)->{
            System.out.println("-------t="+t);
            System.out.println("-------u="+u);
        }).exceptionally(f->{
            System.out.println("-----exception:"+f.getMessage());
            return 444;
        }).get();

    }
}
```





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

> 如果一个类加载器收到了类加载请求，==它并不会自己先去加载==，而是把这个请求委托给父类的加载器去执行；如果父类加载器还存在其父亲加载器，则进一步向上委托，一次递归，请求最终将到达顶层的启动类加载器；==如果父亲加载器可以完成类加载任务，就成功返回，倘若父亲加载器无法完成加载任务，子加载器才会尝试自己去加载==，这就是双亲委派模式。

![image-20200407100908578](E:\dev\javaweb\IDEA\javaExercise\images\ClassLoader3.png)

**优势**

> 避免类的重复加载
>
> 包括程序安全，防止核心API被随意篡改
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

答：①volatile是java虚拟机提供的轻量级的同步机制，包括三个特性：保证可见性，不保证原子性，禁止指令重排（保证了有序性）

② JMM你谈谈？

答：JMM（java内存模型）并不是真实存在。JMM关于同步规定：

- 线程解锁前，必须把共享变量的值刷新回主内存
- 线程加锁前，必须读取主内存的最新值到自己的工作内存
- 加索解锁是同一把锁

```
由于JVM运行程序的实体是线程,而每个线程创建时JVM都会为其创建一个工作内存(有些地方成为栈空间),工作内存是每个线程的私有数据区域,而Java内存模型中规定所有变量都存储在主内存,主内存是共享内存区域,所有线程都可访问,但线程对变量的操作(读取赋值等)必须在工作内存中进行,首先要将变量从主内存拷贝到自己的工作空间,然后对变量进行操作,操作完成再将变量写回主内存,不能直接操作主内存中的变量,各个线程中的工作内存储存着主内存中的变量副本拷贝,因此不同的线程无法访问对方的工作内存,此期间的通讯(传值) 必须通过主内存来完成。
```

![image-20200427222124218](E:\dev\javaweb\IDEA\javaExercise\images\JMM.png)

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





## 四、剑指java校招面试（慕课网299）

### 计算机网络

#### 1 网络协议

![image-20200527095650305](E:\dev\javaweb\IDEA\javaExercise\images\OSI七层模型.png)

![image-20200527095757527](E:\dev\javaweb\IDEA\javaExercise\images\TCPIP.png)

#### 2 说说TCP/IP的三次握手

**传输控制协议TCP简介**

- 面向连接的、可靠的、基于字节流的传输层通信协议
- 将应用层的数据流分割成报文段并发给目标结点的TCP层
- 数据包都幼序号，对方收到则发送ACK确认，未收到则重传
- 使用校验和来检验数据在传输过程中是否有误

>  TCP Flags
>
> > URG：紧急指针标志
> >
> > ACK：确认序号标志
> >
> > PSH：push标志
> >
> > RST：重置连接标志
> >
> > SYN：同步序号，用于建立连接过程
> >
> > FIN：finish标志，用于释放连接

![image-20200527101153075](E:\dev\javaweb\IDEA\javaExercise\images\三次握手.png)

![image-20200527101958031](E:\dev\javaweb\IDEA\javaExercise\images\握手.png)

**为什么需要三次握手才能建立连接？**

答：为了初始化Sequence Number的初始值。

![image-20200527102531361](E:\dev\javaweb\IDEA\javaExercise\images\首次握手的隐患.png)

![image-20200527102721261](E:\dev\javaweb\IDEA\javaExercise\images\SYN.png)

![image-20200527102817030](E:\dev\javaweb\IDEA\javaExercise\images\建立连接后.png)

#### 3 谈谈TCP的四次挥手

![image-20200527103239965](E:\dev\javaweb\IDEA\javaExercise\images\四次挥手.png)

![image-20200527103501507](E:\dev\javaweb\IDEA\javaExercise\images\四次挥手2.png)

**为什么会有TIME_WAIT状态？**

答：确保有足够的时间让对方收到ACK包，避免新旧连接混淆。

**为什么需要四次握手才能断开连接？**

答：因为全双工，发送方和接收方都需要FIN保温和ACK报文。

**服务器出现大量CLOSE_WAIT状态的原因？**

答：对方关闭socket连接，我方忙于读或写，没有及时关闭连接。

>  解决办法：
>
> > 检查代码，特别是释放资源的代码
> >
> > 检查配置，特别是处理请求的线程配置，如线程池设置不合理等

在linux中使用 `netstat`命令用于显示与IP、TCP、UDP和ICMP协议相关的统计数据，一般用于检验本机各端口的网络连接情况。netstat是在内核中访问网络及相关信息的程序，它能提供TCP连接，TCP和UDP监听，进程内存管理的相关报告。

#### 4 UDP简介

![image-20200527104529022](E:\dev\javaweb\IDEA\javaExercise\images\UDP1.png)

**UDP的特点**

- 面向非连接
- 不维护连接状态，支持同时向多个客户端传输相同的消息
- 数据包报头只有8个字节，额外开销较小
- 吞吐量只受限于数据生成速率、传输速率以及机器性能
- 尽最大努力交付，不保证可靠交付，不需要维持复杂的链接状态表
- 面向报文，不对应用程序提交的报文信息进行拆分或者合并

**TCP和UDP的区别**

- TCP是面向连接的，UDP是无连接的
- TCP保证了传输的可靠性，而UDP不能保证
- TCP传输是有序的，而UDP不具备
- TCP比较慢，因为要创建链接等额外的时间消耗，而UDP不需要，更适合做视频，聊天软件
- TCP是重量级的，报头含有20个字节，而UDP可看成是轻量级的，报头包含8个字节



#### 5 TCP的滑动窗口

**RTT和RTO**

- RTT：发送一个数据包到收到对应的ACK，所花费的时间
- RTO：重传时间间隔

**TCP使用滑动窗口做流量控制与乱序重排**

- 保证TCP的可靠性
- 保证TCP的流量控制特性

![image-20200527111506001](E:\dev\javaweb\IDEA\javaExercise\images\TCP滑动窗口.png)

![image-20200527111708547](E:\dev\javaweb\IDEA\javaExercise\images\TCP滑动窗口2.png)

![image-20200527111743568](E:\dev\javaweb\IDEA\javaExercise\images\TCP滑动窗口3.png)

#### 6 HTTP简介

**超文本传输协议HTTP主要特点**

- 支持客户/服务器模式
- 简单快速
- 灵活
- 无连接
- 无状态

**请求/响应的步骤**

- 客户端连接到Web服务器
- 发送HTTP请求
- 服务器接受请求并返回HTTP响应
- 释放连接TCP连接
- 客户端浏览器解析HTML内容

**面试题：在浏览器地址栏输入URL，按下回车之后经历的流程？**

答：① DNS解析  ② TCP连接  ③ 发送HTTP请求   ④ 服务器处理请求并返回HTTP报文  ⑤ 浏览器解析渲染页面  ⑥ 连接结束

详细介绍：首先浏览器会去URL逐层查询DNS，解析URL域名所对应的IP地址，DNS缓存从近到远依次是浏览器缓存、系统缓存、路由器缓存、IPS服务器缓存、根域名服务器缓存、顶级域名服务器缓存，从哪个找到对应的IP则直接返回，不在查询后面的缓存。根据找到的IP地址和对应的端口（默认是80）和服务器建立TCP连接。之后，浏览器会发送HTTP请求，该请求会发送给服务器，服务器处理请求并返回HTTP报文 ，接着，浏览器收到了HTML解析渲染页面，最后浏览器释放TCP连接（四次挥手）。

**面试题：HTTP状态码？**

答：五种可能的取值，如下：

- 1xx：指示信息--表示请求已接受，继续处理
- 2xx：成功--表示请求已被成功接收、理解、接收
- 3xx：重定向--要完成请求必须进行更进一步的操作
- 4xx：客户端错误--请求有语法错误或请求无法实现
- 5xx：服务器端错误--服务器未能实现合法的请求

**常见状态码：**

200 OK:正常返回信息
400 Bad Request:客户端请求有语法错误，不能被服务器所理解
401 Unauthorized:请求未经授权，这个状态代码必须和WWW-Authenticate报头域一起使用
403 Forbidden:服务器收到请求，但是拒绝提供服务
404 Not Found:请求资源不存在，eg,输入了错误的URL
500 Internal Server Error:服务器发生不可预期的错误
503 Server Unavailable:服务器当前不能处理客户端的请求，一段时间后可能恢复正常

**面试题：GET请求和POST请求的区别**

答：从三个层面来解答：

- http报文层面：GET将请求信息放在URL，POST方在报文体中
- 数据库层面：GET符合幂等性和安全性，POST不符合，比如GET用于查询，POST则可以操作改变数据库
- 其他层面：GET可以被缓存、被存储，而POST不行

**面试题：Cookie和Session区别**

答：

> Cookie简介：
>
> - 是由服务器发送给客户端的特殊信息，以文本的性识存放在客户端
> - 客户端再次请求的时候，会把Cookie回发
> - 服务器接收到后，会解析Cookie生成与客户端相对应的内容

<img src="E:\dev\javaweb\IDEA\javaExercise\images\Cookie.png" alt="image-20200527115907188" style="zoom:67%;" />

> Session简介
>
> - 服务器端的机制，在服务器上保存的信息
> - 解析客户端请求并操作sessionid， 按需保存状态信息

<img src="E:\dev\javaweb\IDEA\javaExercise\images\Session.png" alt="image-20200527142333647" style="zoom:67%;" />

**Session与Cookie区别？**

- Cookid数据存放在客户的浏览器上，Session数据放在服务器上
- Session相对于Cookie更安全
- 若考虑减轻服务器负担，应当使用Cookie



#### 7 HTTP与HTTPS的区别

![image-20200527142641979](E:\dev\javaweb\IDEA\javaExercise\images\HTTP.png)

```
SSL(Security Sockets Layer ,安全套接层)
➢ 为网络通信提供安全及数据完整性的一种安全协议
➢是操作系统对外的API , SSL3.0后更名为TLS
➢采用身份验证和数据加密保证网络通信的安全和数据的完整性

加密的方式
➢对称加密:加密和解密都使用同一个密钥
➢非对称加密:加密使用的密钥和解密使用的密钥是不相同的
➢哈希算法:将任意长度的信息转换为固定长度的值,算法不可逆
➢数字签名:证明某个消息或者文件是某人发出/认同的

HTTPS数据传输流程
➢浏览器将支持的加密算法信息发送给服务器
➢服务器选择-套浏览器支持的加密算法,以证书的形式回发浏览器
➢浏览器验证证书合法性,并结合证书公钥加密信息发送给服务器
➢服务器使用私钥解密信息,验证哈希,加密响应消息回发浏览器
➢浏览器解密响应消息,并对消息进行验真,之后进行加密交互数据
```

**HTTP与HTTPS的区别**

➢HTTPS需要到CA申请证书, HTTP不需要
➢HTTPS密文传输, HTTP明文传输
➢连接方式不同, HTTPS默认使用443端口, HTTP使用80端口
➢HTTPS= HTTP+加密+认证+完整性保护,较HTTP安全

<img src="E:\dev\javaweb\IDEA\javaExercise\images\HTTPS.png" alt="image-20200527143644592" style="zoom:67%;" />

#### 8 Socket简介

![image-20200527143837455](E:\dev\javaweb\IDEA\javaExercise\images\Socket.png)

![image-20200527143952047](E:\dev\javaweb\IDEA\javaExercise\images\Socket通信.png)

**面试题：Socket相关的面试题**

编写一个网络应用程序，有客户端与服务器端，客户端向服务器发送一个字符串，服务器收到该字符串后将其打印到命令行上，然后向客户端返回该字符串的长度，最后，客户端输出服务器端返回的该字符串的长度，分别用TCP和UDP两种方式去实现。

具体代码详见：[此处](https://github.com/BMDACMER/javaExercise/tree/master/interview/src/main/java/com/interview/javabasic/socket)

### 数据库

<img src="E:\dev\javaweb\IDEA\javaExercise\images\关系型数据库考点.png" alt="image-20200527155617663" style="zoom:67%;" />

<img src="E:\dev\javaweb\IDEA\javaExercise\images\RDBMS.png" alt="image-20200527160111894" style="zoom:67%;" />

#### 9 索引模块

>  为什么要使用索引？ 
>
> > - 快速查询数据

> 什么样的信息能成为索引？
>
> - 主键、唯一键以及普通键等

> 索引的数据结构
>
> - 生成索引，建立二叉查找树进行二分查找
> - 生成索引，建立B-Tree结构进行查找
> - 生成索引，建立B+-Tree结构进行查找
> - 生成索引，建立Hash结构进行查找

**B树（B-Tree）**也即B-树

![image-20200527161820878](E:\dev\javaweb\IDEA\javaExercise\images\B-Tree.png)

定义：

- 根结点至少包括两个孩子
- 树中每个结点最多含有m个孩子（m>=2）
- 除根结点和叶节点外，其他每个结点至少有ceil(m/2)个孩子
- 所有叶子结点都位于同一层

假设每个非终端结点中包含有n个关键字信息，其中
a) Ki (i1..n)为关键字,且关键字按顺序升序排序K(i-1)< Ki
b)关键字的个数n必须满足: [ceil(m/ 2)-1]<=n <= m-1
c)非叶子结点的指针 :P[1], P[2], .... P[M] ;其中P[1]指向关键字小于K[1]的子树, P[M]
指向关键字大于K[M-1]的子树,其它P[]指向关键字属于(K[i-1], K[i])的子树

**B+树**

![image-20200527162617685](E:\dev\javaweb\IDEA\javaExercise\images\B+树.png)

![image-20200527162735977](E:\dev\javaweb\IDEA\javaExercise\images\B+树2.png)

<img src="E:\dev\javaweb\IDEA\javaExercise\images\结论.png" alt="image-20200527162927132" style="zoom:67%;" />

![image-20200527163227699](E:\dev\javaweb\IDEA\javaExercise\images\Hash索引.png)

**注释：通常使用的是B+树**

#### 10 密集索引和稀疏索引的区别

- 密集索引文件中的每个搜索码值都对应一个索引值
- 稀疏索引文件只为索引码的某些值建立索引项

![image-20200527164055366](E:\dev\javaweb\IDEA\javaExercise\images\密集索引.png)

**额外知识--InnoDB**

- 若一个主键被定义，该主键则作为密集索引
- 若没有主键被定义，该表的第一个唯一非空索引则作为密集索引
- 若不满足以上条件，innodb内部会生成一个隐藏主键（密集索引）
- 非主键索引存储相关键位和其对应的主键值，包含两次查找

![image-20200527165005891](E:\dev\javaweb\IDEA\javaExercise\images\InnoDB.png)

#### 11 如何定位并优化慢查询SQL

具体场景具体分析，只提出大致思路：

- 根据慢日志定位慢查询sql
- 使用explain等工具分析sql
- 修改sql或者尽量让sql走索引



**Explain关键字段**

- type

  system>const>eq_ ref>ref>fulltext>ref _or_ null>index merge>unique_ subquery> index. subquery> range>==index>all==

- extra

<img src="E:\dev\javaweb\IDEA\javaExercise\images\extra.png" alt="image-20200527170846250" style="zoom:67%;" />

#### 12 联合索引的最左匹配原则的成因

![image-20200527172044042](E:\dev\javaweb\IDEA\javaExercise\images\联合索引.png)

1.最左前缀匹配原则，非常重要的原则，mysq|会- -直向右匹配直到遇到范围查询(>、 <、between、like)就停止匹配 ,比如a = 3 andb = 4 andc > 5 and d = 6如果建立(a,b,c,d)顺序的索引，d是用不到索引的,如果建立(a,b,d,c)的索引|则都可以用到, a,b,d的顺序可以任意调整。

2.=和in可以乱序,比如a = 1 andb= 2 andc= 3建立(a,b,c)索引可以任意顺序, mysql的查询优化器会帮你优化成索引可以识别的形式.

#### 13 索引是建立得越多越好吗？

➢数据量小的表不需要建立索引,建立会增加额外的索引开销
➢数据变更需要维护索引,因此更多的索弓|意味着更多的维护成本
➢更多的索弓|意味着也需要更多的空间

#### 14 锁模块

<img src="E:\dev\javaweb\IDEA\javaExercise\images\锁模块.png" alt="image-20200527172708179" style="zoom:67%;" />

<img src="E:\dev\javaweb\IDEA\javaExercise\images\共享锁和排斥锁的兼容性.png" alt="image-20200527175108192" style="zoom:67%;" />

**MyISAM适合的场景**

- 频繁执行全表count语句
- 对数据进行增删改的频率不高，查询非常频繁
- 没有事务

**InnoDB适合的场景**

- 数据增删改查都相当频繁
- 可靠性要求比较高，要求支持事务

**数据库锁的分类**

- 按锁的粒度划分，可分为表级锁、行级锁、页级锁。其中InnoDB默认支持行级锁也支持表级锁，MyISAM仅支持表级锁。而页级锁是一种介于表级锁和行级锁之间的锁，不常用的BDB引擎支持页级锁。
- 按锁级别划分，可分为 共享锁、排他锁
- 按加锁方式划分，可分为自动锁、显示锁
- 按操作划分，可分为DML锁、DDL锁
- 按使用方式划分，可分为乐观锁、悲观锁（比如加syncharonized）

#### 15 数据库事务的四大特性

>  ACID
>
> - 原子性（Atomic）：事务执行要么全部执行要么全部失败回滚
> - 一致性（Consistency）
> - 隔离性（Isolation）：并发执行时，各事务互不影响
> - 持久性（Durability）

#### 16 事务并发访问引起的问题以及如何避免

- 更新丢失---mysql所有事务隔离级别在数据库层面上均可避免
- 脏读--READ-COMMITTED事务隔离级别以上可避免（oracle默认这个）
- 不可重复读--REPEATABLE-READ事务隔离级别以上可避免（mysql默认这个级别）
- 幻读--SERIALIZABLE事务隔离级别可避免

<img src="E:\dev\javaweb\IDEA\javaExercise\images\事务并发访问.png" alt="image-20200527185547614" style="zoom:67%;" />

**丢失修改**：T1和T2两个事务都对一个数据进行==修改==，T1先修改，T2随后修改，T2的修改覆盖了T1的修改。

**脏读**：T1修改一个数据，T2随后读取这个数据。如果T==1撤销了这次修改==，那么T2读取的数据是脏数据。

**不可重复读**：T2读取一个数据，T1对该数据做了==修改==。如果T2再次读取这个数据，此时读取的结果和第一次读取的结果不同。

**幻影读**：T1读取某个范围的数据，T2在这个范围内==插入==新的数据，T1再次读取这个范围的数据，此时读取的结果和和第一次读取的结果不同。

#### 17  InnoDB可重复读隔离级别下如何避免幻读

- 表象：快照读（非阻塞读） -- 伪MVCC
- 内在：next-key锁（行锁+gap锁）

**当前读和快照读**

> ➢当前读: selec...lock in share mode , select.. .for update
> ➢当前读: update , delete , insert
> ➢快照读:不加锁的非阻塞读, select

> RC、RR级别下的InnoDB的非阻塞读如何实现
> ➢数据行里的DB_TRX_ID、DB_ROLL_PTR、DB_ROW_ID字段
> ➢undo日志
> ➢read view



**对主键索引或者唯一索引会用Gap锁吗？**
➢如果where条件全部命中,则不会用Gap锁,只会加记录锁
➢如果where条件部分命中或者全不命中,则会加Gap锁

**Gap锁会用在非唯一索引或者不走索引的当前读中**

#### 18 语法部分

<img src="E:\dev\javaweb\IDEA\javaExercise\images\关键语法.png" alt="image-20200527203641805" style="zoom:67%;" />

<img src="E:\dev\javaweb\IDEA\javaExercise\images\groupBy.png" alt="image-20200527203753645" style="zoom:67%;" />

<img src="E:\dev\javaweb\IDEA\javaExercise\images\HAVING.png" alt="image-20200527205644550" style="zoom:67%;" />



#### 彩蛋--面试的三层架构

- 首轮：面试技术基本功
- 次轮：架构涉及，通过技术解决某些场景下的问题
- 末轮：稳定性以及未来规划，压工资

### Redis

关于Redis的入门教程可点击[此处](https://zhuanlan.zhihu.com/p/37055648)和[菜鸟教程](https://www.runoob.com/redis/redis-tutorial.html)。

#### 基础知识

>  Redis里头是两个HashTable线程安全的。
>
> 可以通过Redis命令行在代码里对Hash表进行操作相当于Redis客户端，而Hash表所在的是Redis服务端（Server），也就是说Redis其实是一个C/S架构。Client和Server可以在一台机器上也可以不在。
>
> **Redis的Server是单线程服务器**，基于**Event-Loop模式**来处理Client的请求，这一点和NodeJS很相似。使用单线程的好处包括：
>
> - **不必考虑线程安全问题。**很多操作都不必加锁，既简化了开发，又提高了性能；
> - **减少线程切换损耗的时间。**线程一多，CPU在线程之间切来切去是非常耗时的，单线程服务器则没有了这个烦恼；
>
> 







<img src="E:\dev\javaweb\IDEA\javaExercise\images\主流应用架构.png" alt="image-20200527211154882"  />

>  Memcache：代码层次类似于Hash
>
> - 支持简单数据类型
> - 不支持数据持久化存储
> - 不支持主从
> - 不支持分片

> Redis
>
> - 数据类型丰富
> - 支持数据磁盘持久化存储
> - 支持主从
> - 支持分片

![image-20200527212158507](E:\dev\javaweb\IDEA\javaExercise\images\Redis1.png)

 ![image-20200527212524650](E:\dev\javaweb\IDEA\javaExercise\images\Redis2.png)

![image-20200527212732237](E:\dev\javaweb\IDEA\javaExercise\images\Select.png)

![image-20200527212458503](E:\dev\javaweb\IDEA\javaExercise\images\redis3.png)

#### 19 说说你用过的Redis的数据类型

> 供用户使用的数据类型
>
> - String：最基本的数据类型，二进制安全，最大存储512MB
> - Hash：String元素组成的字典，适合用于存储对象
> - List：列表，按照String元素插入顺序排序
> - Set：String元素组成的无需集合，通过哈希表实现，不允许重复
> - Sorted Set： 也即zset，每个元素都会关联一个double类型的分数。通过分数来为集合中的成员进行从小到大的排序，zset的成员是唯一的,但分数(score)却可以重复。
> - 用于计数的HyperLogLog，用于支持存储地理位置信息的Geo

<img src="E:\dev\javaweb\IDEA\javaExercise\images\底层数据类型基础.png" alt="image-20200527213843016" style="zoom:67%;" />

#### 20 从海量Key里查询出某一固定前缀的Key

注意：首先得问清楚数据规模。

常规答案：采用Keys 指令：查找所有符号给定模式的key  ==eg: keys k1*==   

- keys指令一次性返回所有匹配的key
- 键的数量过大会使服务卡顿

改进方法：使用scan cursor [match pattern] [COUNTcount] ==eg: scan 0 match k1* count 10==

- ➢基于游标的迭代器,需要基于.上一次的游标延续之前的迭代过程
  ➢以0作为游标开始一次新的迭代,直到命令返回游标0完成一-次遍历
  ➢不保证每次执行都返回某个给定数量的元素,支持模糊查询
  ➢一次返回的数量不可控,只能是大概率符合count参数



#### 21如何通过Redis实现分布式锁

分布式锁需要解决的问题：1）互斥性   2） 安全性  3） 死锁  4） 容错

**SETNX key value：如果key不存在，则创建并赋值**

- 时间复杂度：O(1)
- 返回值：设置成功，返回1；设置失败，返回0

**EXPIRE key seconds**:设置key的生存时间，当key过期时（生存时间为0），会被自动删除；缺点：原子性得不到满足

**SET key value [EX seconds] [PX milliseconds] [NX|XX]**
➢EX second :设置键的过期时间为second秒
➢PX millisecond :设置键的过期时间为millisecond毫秒
➢NX :只在键不存在时,才对键进行设置操作
➢XX:只在键已经存在时,才对键进行设置操作
➢SET操作成功完成时,返回OK ,否则返回nil 

**集中过期,由于清除大量的key很耗时,会出现短暂的卡顿现象**
➢解放方案:在设置key的过期时间的时候,给每个key加上**随机值**

#### 22 如何使用Redis做异步队列

> 使用List作为队列，RPUSH生产消息，LPOP消费消息
>
> - 缺点：没有等待队列里有值就直接消费
> - 弥补：可以通过在应用层引入Sleep机制去调用LPOP重试
>
> BLPOP key [key .. timeout :阻塞直到队列有消息或者超时
> ➢缺点:只能供一个消费者消费
>
> pub/sub :主题订阅者模式
> ➢发送者(pub)发送消息,订阅者(sub)接收消息
> ➢订阅者可以订阅任意数量的频道
>
> pub/sub的缺点：消息的发布时无状态的，无法保证可达



#### 23 Redis如何做持久化

Redis提供了三种持久化方式：

**1、RDB（快照）持久化**：保存某个时间点的全量数据快照

- SAVE：阻塞Resid的服务器进程，直到RDB文件被创建完毕
- ==BGSAVE：Fork出一个子进程来创建RDB文件，不阻塞服务器进程==



自动化触发RDB持久化的方式
➢根据redis.conf配置里的SAVE m n定时触发(用的是BGSAVE )
➢主从复制时,主节点自动触发
➢执行Debug Reload
➢执行Shutdown且没有开启AOF持久化

BGSAVE原理：

![img](E:\dev\javaweb\IDEA\javaExercise\images\BGSAVE.png)

`注意:`bgsave命令是针对save阻塞问题做的优化。Redis内部所有涉及到RDB操作都采用basave的方式,save命令可以放弃使用。

Copy-on-Write
如果有多个调用者同时要求相同资源(如内存或磁盘上的数据存储)，他们会共同获取相同的指针指向相同的资源，直到某个调用者试图修改资源的内容时，系统才会真正复制一份专用副本给该调用者，而其他调用者所见到的最初的资源仍然保持不变。

RDB持久化的缺点
➢内存数据的全量同步,数据量大会由于I/O而严重影响性能
➢可能会因为Redis挂掉而丢失从当前至最近一-次快照期间的数据

**2、AOF（Append-Only-File）持久化**：保存写状态

- 记录下除了查询以外的所有变更数据库状态的指令
- 以append的形式追加保存到AOF文件中( 增量)

![image-20200528005006309](E:\dev\javaweb\IDEA\javaExercise\images\AOF.png)

![image-20200528005032538](E:\dev\javaweb\IDEA\javaExercise\images\Redis比较.png)

![image-20200528005055419](E:\dev\javaweb\IDEA\javaExercise\images\RDB和AOF.png)

**3 RDB-AOF混合持久化方式**

BGSAVE做镜像全量持久化，AOF做增量持久化



#### 24 使用Pipeline的好处

➢Pipeline和Linux的管道类似
➢Redis基 于请求/响应模型,单个请求处理需要一-应答
➢Pipeline批量执行指令,节省多次IO往返的时间
➢有顺序依赖的指令建议分批发送



#### 25 Redis的同步机制

<img src="E:\dev\javaweb\IDEA\javaExercise\images\主从同步原理.png" alt="image-20200528005558898" style="zoom:67%;" />

**全同步过程**
➢Salve发送sync命令 到Master
➢Master启动- 个后台进程,将Redis中的数据快照保存到文件中
➢Master将保存数据快照期间接收到的写命令缓存起来
➢Master完成写文件操作后, 将该文件发送给Salve
➢使用新的AOF文件替换掉旧的AOF文件
➢Master将这期间收集的增量写命令发送给Salve端

**增量同步过程**
➢Master接收到用户的操作指令,判断是否需要传播到Slave
➢将操作记录追加到AOF文件
➢将操作传播到其他Slave : 1、对齐主从库; 2、往响应缓存写入指令
➢将缓存中的数据发送给Slave

![image-20200528005840724](E:\dev\javaweb\IDEA\javaExercise\images\RedisSentinel.png)

![image-20200528005934909](E:\dev\javaweb\IDEA\javaExercise\images\Gossip.png)

#### 26 Redis的集群原理

如何从海量数据里快速找到所需?
➢分片:按照某种规则去划分数据,分散存储在多个节点上
➢常规的按照哈希划分无法实现节点的动态增减

![image-20200528010255762](E:\dev\javaweb\IDEA\javaExercise\images\集群原理.png)

![image-20200528010640285](E:\dev\javaweb\IDEA\javaExercise\images\引入虚拟结点.png)

### Linux

#### 27  如何查找特定的文件

> find
>
> >  语法  find path [options] params
>
> eg： find ~ -name "target*"   // 查找当前home目录下所有以target开头的文件

![image-20200528093058836](E:\dev\javaweb\IDEA\javaExercise\images\find.png)



#### 28 检索文件内容

> grep
>
> > 语法: grep [options] pattern file
>
> 全称：Global Regular Expression Print
>
> 作用：查找文件里符合添加的字符串
>
> eg:  grep "moo" target*    // 以target开头的文件包含moo的内容，没有的话什么也不返回

> 管道操作符 |
>
> > 可将指令连接起来，前一个指令的输出作为后一个指令的输入
>
> eg：find ~ | grep "target"

<img src="E:\dev\javaweb\IDEA\javaExercise\images\grep.png" alt="image-20200528093845721" style="zoom:67%;" />

<img src="E:\dev\javaweb\IDEA\javaExercise\images\grep2.png" alt="image-20200528094127278" style="zoom:67%;" />

#### 29 对文件内容做统计

> awk
>
> > 语法： awk [options] 'cmd' file
>
> - 一次读取一行文件，按输入分隔符进行切片，切成多个组成部分
>
> - 将切片直接保存在内建的变量中，\$1,\$2...(\$0表示行的全部)
> - 支持对单个切片的判断，支持循环判断，默认分隔符为空格

![image-20200528094731612](E:\dev\javaweb\IDEA\javaExercise\images\文件统计.png)

![image-20200528095037319](E:\dev\javaweb\IDEA\javaExercise\images\awk.png)

#### 30 批量替换文本内容

> sed
>
> > 语法：sed [option] 'sed command' filename
>
> - 全名stream editor, 流编辑器
> - 适合用于对文本的**行内容**进行处理
>
> eg： sed 's/^Str/String/' replace.java   // 将replace.java中的Str开头的字符串替换为String 但执行后只会在终端更改，并不会修改源文件内容 这时可添加 `-i`来解决
>
>  sed -i 's/^Str/String/' replace.java  //  // 将replace.java中的Str开头的字符串替换为String，源文本也修改了

![image-20200528095818863](E:\dev\javaweb\IDEA\javaExercise\images\sed.png)



#### 面试彩蛋

<img src="E:\dev\javaweb\IDEA\javaExercise\images\面试彩蛋.png" alt="image-20200528100237106" style="zoom:67%;" />



### JVM

#### 31 谈谈你对java的理解

- 平台无关性
- GC
- 语言特性（集合，泛型，λ表达式，流式。。。）
- 面向对象
- 类库
- 异常处理

![image-20200528101358876](E:\dev\javaweb\IDEA\javaExercise\images\java1.png)

**为什么JVM不直接将源码解析成机器码去执行**？

答：准备工作：每次执行都需要各种语法句法检查，整体性能受影响；兼容性：也可以将别的语言解析成字节码（比如Groovy，Scala等） 查看java字节码的命令`javap`

#### 32 JVM如何加载.class文件

![image-20200528102124538](E:\dev\javaweb\IDEA\javaExercise\images\java虚拟机.png)

**谈谈反射**：JAVA反射机制是在运行状态中,对于任意-一个类,都能够知道这个类的所有属性和方法;对于任意一个对象,都能够调用它的任意方法和属性;这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。

**ClassLoader**在Java中有着非常重要的作用, 它主要工作在Class装载的加载阶段,其主要作用是从系统外部获得Class二进制数据流。它是Java的核心组件，所有的Class都是由ClassLoader进行加载的，ClassLoader负责通过将Class文件里的二进制数据流装载进系统,然后交给Java虚拟机进行连接、初始化等操作。[code](https://github.com/BMDACMER/javaExercise/tree/master/interview/src/main/java/com/interview/javabasic/reflect)

**ClassLoader种类**：[code](https://github.com/BMDACMER/javaExercise/tree/master/interview/src/main/java/com/interview/javabasic/reflect)

- BootStrapClassLoader： C++编写，加载核心库java.*
- ExtClassLoader：Java编写，加载扩展库javax.*
- AppClassLoader：Java编写，加载程序所在目录
- 自定义ClassLoader：Java编写，定制化加载

#### 33 谈谈类加载器的双亲委派机制

![image-20200528122136801](E:\dev\javaweb\IDEA\javaExercise\images\双亲委派机制.png)

类加载方式：

- 隐式加载：new
- 显式加载：loadClass, forName等

#### 34 java内存模型

![image-20200528123608028](E:\dev\javaweb\IDEA\javaExercise\images\内存空间.png)

![image-20200528123733924](E:\dev\javaweb\IDEA\javaExercise\images\JDK内存模型.png)

> 程序计数器
>
> - 当前线程所执行的字节码行号指示器（逻辑）
> - 改变计数器的值来选取下一条需要执行的字节码指令
> - 和线程是一对一的关系即“线程私有”
> - 对java方法计数，如果是Native方法则计数器值为Undefined
> - 不会发生内存泄漏

> Java虚拟机栈（Stack）
>
> - Java方法执行的内存模型
> - 包含多个栈帧

> 局部变量表和操作数栈
>
> - 局部变量表：包含方法执行过程中的所有变量
> - 操作数栈：入栈、出栈、复制、交换、产生消费变量

> 本地方法栈
>
> - 与虚拟机栈相似，主要作用于标注了native的方法

> 元空间(MetaSoace)与永久代(PermGen)的区别
>
> - 元空间使用本地内存，而永久代使用的是JVM的内存
> - java.lang.OutOfMemoryError: PermGen space

**MetaSpace相比PermGen的优势**

- 字符串常量池存放在永久代中，容易出现性能问题和内存溢出
- 类和方法的信息大小难以确定，给永久代的大小指定带来困难
- 永久代会为GC带来不必要的复杂性
- 方便HotSpot与其他JVM如Jrockit的集成

> Java堆（Heap）
>
> - 对象实例的分配区域
> - GC管理的主要区域    （新生代+老年代）



#### 35 JVM三大性能调优参数 \-Xms  \-Xmx   \-Xss 

**-Xss**: 规定了每个线程虚拟机栈（堆栈）的大小

**-Xms**: 堆的初始值

**-Xmx**: 堆能达到的最大值

![image-20200528154019329](E:\dev\javaweb\IDEA\javaExercise\images\JVM调优.png)

一般情况下，-Xms与-Xmx设置相同，因为如果初始化的Xms的堆内存不足时，会扩容，产生抖动影响性能，所以一般就将-Xms与-Xmx设置相同的大小。

**Java内存模型中==堆和栈==的区别----内存分配策略**

- 静态存储：编译时确定每个数据目标在运行时的存储空间需求
- 栈式存储：数据区需求在编译时未知，运行时模块入口前确定
- 堆式存储：编译时或运行时模块入口都无法确定，动态分配

**堆和栈的联系**：引用对象、数组时，栈里定义变量保存堆中目标的首地址

![image-20200528160650387](E:\dev\javaweb\IDEA\javaExercise\images\堆和栈.png)

**区别**：

- 管理方式：栈自动释放，堆需要GC
- 空间大小：栈比堆小
- 碎片相关：栈产生的碎片远小于堆
- 分配方式：==栈支持静态和动态分配，而堆仅支持动态分配==
- 效率：栈的效率比堆高

![image-20200528161135168](E:\dev\javaweb\IDEA\javaExercise\images\元空间堆线程独占部分间的联系.png)

![image-20200528161304125](E:\dev\javaweb\IDEA\javaExercise\images\intern.png)

![image-20200528161527536](E:\dev\javaweb\IDEA\javaExercise\images\intern6.png)

==在JDK6中，输出结果为false   false;但在JDK6+以上版本，输出结果为false, true;==

#### ![image-20200528161554923](E:\dev\javaweb\IDEA\javaExercise\images\intern6+.png)

#### 36 垃圾回收机制

##### 判断对象是否为垃圾的算法

- 引用计数法
- 可达性分析法



> 引用计数法
>
> 判断对象的引用数量
>
> - 通过判断对象的引用数量来决定对象是否可以被回收
> - 每个对象实例都有一个引用计数器，被引用则+1，完成引用则-1
> - 任何==引用计数为0==的对象实例可以==被当作垃圾收集==
>
> 优点：执行效率高，程序执行受影响小
>
> 缺点：无法检测出循环引用的情况，导致内存泄漏

> 可达性分析算法
>
> 通过判断对象的引用链是否可达来决定对象是否可以被回收

> 可以作为GC Root的对象
>
> - 虚拟机栈中引用的对象（栈帧中的本地变量表）
> - 方法区中的常量引用的对象
> - 方法区中的类静态属性引用的对象
> - 本地方法栈中JNI（Native方法）的引用对象
> - 活跃线程的引用对象

![image-20200528165325353](E:\dev\javaweb\IDEA\javaExercise\images\可达性分析.png)



##### 谈谈你了解的垃圾回收算法

![image-20200528181422757](E:\dev\javaweb\IDEA\javaExercise\images\标记-清除算法7.png)

![image-20200528181508025](E:\dev\javaweb\IDEA\javaExercise\images\复制算法.png)

![image-20200528181721184](E:\dev\javaweb\IDEA\javaExercise\images\标记-整理算法.png)

![image-20200528181811209](E:\dev\javaweb\IDEA\javaExercise\images\分代收集算法.png)

![image-20200528181921034](E:\dev\javaweb\IDEA\javaExercise\images\GC.png)

![image-20200528182547136](E:\dev\javaweb\IDEA\javaExercise\images\年轻代.png)

![image-20200528182857122](E:\dev\javaweb\IDEA\javaExercise\images\晋升到老年代.png)

![image-20200528183004376](E:\dev\javaweb\IDEA\javaExercise\images\参数调优.png)

![image-20200528183047234](E:\dev\javaweb\IDEA\javaExercise\images\老年代.png)

![image-20200528183120242](E:\dev\javaweb\IDEA\javaExercise\images\老年代2.png)

![image-20200528183409396](E:\dev\javaweb\IDEA\javaExercise\images\FullGC.png)



##### 常见的垃圾收集器

> Stop-the-World
>
> - JVM由于要执行GC而停止了应用程序的执行
> - 任何一种GC算法中都会发生
> - 多数GC优化通过减少Stop-the-World发生的时间来提高程序的性能

> Safepoint
>
> - 分析过程中对象引用关系不会发生变化的点
> - 产生Safepoint的地方：==方法调用；循环跳转；异常跳转==等
> - 安全点数量得适中，太多的话会影响性能。



> JVM的运行模式
>
> - Server 启动较慢  重量级虚拟机
> - Client 启动较快  轻量级虚拟机



垃圾收集器之间的联系

![image-20200528184256154](E:\dev\javaweb\IDEA\javaExercise\images\垃圾收集器.png)

![image-20200528184438489](E:\dev\javaweb\IDEA\javaExercise\images\Serial.png)

![image-20200528184658791](E:\dev\javaweb\IDEA\javaExercise\images\ParNew.png)

![image-20200528203143991](E:\dev\javaweb\IDEA\javaExercise\images\ParallelScavenge.png)

![image-20200528203245488](E:\dev\javaweb\IDEA\javaExercise\images\ParallelScavenge2.png)

![image-20200528203419586](E:\dev\javaweb\IDEA\javaExercise\images\SerialOld.png)

![image-20200528203512146](E:\dev\javaweb\IDEA\javaExercise\images\ParallerOld46.png)

![image-20200528203702729](E:\dev\javaweb\IDEA\javaExercise\images\CMS.png)

![image-20200528203721501](E:\dev\javaweb\IDEA\javaExercise\images\CMS2.png)

![image-20200528203840364](E:\dev\javaweb\IDEA\javaExercise\images\G1.png)

![image-20200528204003162](E:\dev\javaweb\IDEA\javaExercise\images\G1_.png)

#### 37 GC相关面试题

##### Object的finalize()方法的作用是否与C++的析构函数作用相同？

答：① 与C++的析构函数不同，析构函数调用确定，而它的是不确定的  ②将未被引用的对象放置于F-Queue队列 ③ 方法执行随时会被终止  ④  给予对象最后一次重生的机会



##### Java中的强引用，软引用，弱引用，虚引用有什么用呢？

> 强引用
>
> - 最普遍的引用： Object obj = new Object()
> - 抛出OutOfMemoryError终止程序也不会回收具有强引用的对象
> - 通过将对象设置为null来弱化引用，使其被回收

> 软引用
>
> - 对象处在有用但非必须的状态
> - ==只有当内存空间不足时，GC会回收该引用的对象的内存==
> - 可以用来实现高速缓存

```java
String str = new String("abc");   // 强引用
SoftReference<String> softRef = new SoftReference<String>(str);    // 软引用
```

> 弱引用
>
> - 非必须的对象，比软引用更弱一些
> - GC时会被回收
> - 被回收的概率也不大，因为GC线程优先级较低
> - 适用于引用偶尔被使用且不影响垃圾收集的对象

```java
String str = new String("abc");
WeakReference<String> abcWeakRef = new WeakReference<String>(str);
```

> 虚引用
>
> - 不会决定对象的声明周期
> - 任何时候都可以被垃圾收集器回收
> - ==跟踪对象被垃圾收集器回收的活动，起哨兵作用==
> - 必须和引用队列ReferenceQueue联合使用

```java
String str = new String("abc");
ReferenceQueue queue = new ReferenceQueue();
PhantomReference ref = new PhantomRefernce(str, queue);
```

**强引用 > 软引用 > 弱引用 >  虚引用** 

![image-20200528211313594](E:\dev\javaweb\IDEA\javaExercise\images\引用4.png)

![image-20200528211502135](E:\dev\javaweb\IDEA\javaExercise\images\类层次结构.png)

> 引用队列
>
> - 无实际存储结构，存储逻辑依赖于内部结点之间的关系来表达
> - 存储关联的且被GC的软引用，弱引用以及虚引用