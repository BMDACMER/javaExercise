package java_multithreading_skills_01.com.isAliveMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 15:16
 */
public class Run {
    public static void main(String[] args) {
       /* MyThread myThread = new MyThread();
        System.out.println("begin=" + myThread.isAlive());
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end=" + myThread.isAlive());*/

       // Demo2
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive=" + t1.isAlive());
    }
}
