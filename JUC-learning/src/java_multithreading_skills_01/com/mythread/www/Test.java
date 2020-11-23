package java_multithreading_skills_01.com.mythread.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 13:20
 */
public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread(1);
        thread.setName("myThread");

//        thread.start();
        thread.run();



        for (int i = 0; i < 10000; i++) {
            System.out.println("main=" + Thread.currentThread().getName());
        }

    }
}
