package java01;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number = 0;
//    int number = 0;

    public void addT060(){
        this.number = 60;
    }

    // 请注意：此时number前面是加了volatile关键字修饰
    public void  addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}

/**
 *1 验证volatile的可见性
 *    1.1 加入 int number = 0;  number变量之前根本没有添加volatile关键字修饰，没有可见性
 *    1.2 添加了volatile，可以解决可见性问题
 *
 * 2 验证volatile不保证原子性
 *   2.1 原子性是什么意思？
 *       不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加载或者被分割。需要整体完整
 *       要么同时成功，要么同时失败
 *   2.2 volatile不保证原子性的案例演示
 *   2.3 why
 *   2.4 如何解决原子性？
 *      * 加syn
 *      * 使用JUC下AtomicInteger
 *
 *
 *
 */
public class Code_003_Volatile {
    // volatile可以保证可见性，及时通知其它线程，主物理内存的值已经被修改
    @Test
    public void seeOkByVolatile(){
        MyData myData = new MyData();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 暂停会
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        },"AAA").start();

        while (myData.number == 0){
            // main线程就一直在这样等待循环，直到number值不在等于零
        }

        System.out.println(Thread.currentThread().getName() + "\t miss is over");
    }

    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; ++i){
            new Thread(() -> {
                for (int j = 0; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程全部计算完成后，再用main线程取得最终的结果值看是多少？
        // 暂停一会线程
        while (Thread.activeCount() > 2){   // 默认两个线程 一个为main 一个为gc线程
            Thread.yield();
        }

        // main 线程
        System.out.println(Thread.currentThread().getName() +
                " \t int finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + " \t AtomicInteger type, " +
                " finally number value: " + myData.atomicInteger);
    }


}
