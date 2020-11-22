package java_multithreading_skills_01.com.mythread.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 17:39
 *
 * 线程随机性的展现    P11
 */
public class RandomThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(1);
        myThread.setName("myThread");
        myThread.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }
}
