package java_multithreading_skills_01.com.shareInstance.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 20:54
 */
public class Run {
    public static void main(String[] args) {
        /*MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();*/
        MyThread myThread = new MyThread("MyThread");
        Thread t1 = new Thread(myThread,"A");
        Thread t2 = new Thread(myThread, "B");
        Thread t3 = new Thread(myThread, "C");
        Thread t4 = new Thread(myThread, "D");
        t3.start();
        t2.start();
        t1.start();
        t4.start();
    }
}
