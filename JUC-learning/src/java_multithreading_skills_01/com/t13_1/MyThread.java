package java_multithreading_skills_01.com.t13_1;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/24 22:45
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 50000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("已经是停止状态了，我要推出了~");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
        } catch (InterruptedException e) {
            System.out.println("进MyThread.java类run方法中的catch了！");
            e.printStackTrace();
        }
    }
}
