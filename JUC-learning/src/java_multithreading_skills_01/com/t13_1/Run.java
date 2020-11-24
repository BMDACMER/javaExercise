package java_multithreading_skills_01.com.t13_1;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/24 22:48
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }
}
