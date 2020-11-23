package java_multithreading_skills_01.com.sleepMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 23:16
 */
public class Run1 {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        System.out.println("begin = " + System.currentTimeMillis());
        myThread.run();
        System.out.println("end = " + System.currentTimeMillis());
    }
}
