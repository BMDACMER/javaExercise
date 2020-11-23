package java_multithreading_skills_01.com.mythread.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 16:48
 */
public class MyThread extends Thread{
    /*@Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }*/

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("run=" + Thread.currentThread().getName());
        }
    }

    // P12
    private int i;

    public MyThread(int i) {
        super();
        this.i = i;
    }

   /* @Override
    public void run() {
        System.out.println(i);
    }*/
}
