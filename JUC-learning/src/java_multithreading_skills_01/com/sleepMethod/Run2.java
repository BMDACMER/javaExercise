package java_multithreading_skills_01.com.sleepMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 23:22
 */
public class Run2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        System.out.println("begin=" + System.currentTimeMillis());
        myThread2.start();
        System.out.println("end=" + System.currentTimeMillis());
    }
}
