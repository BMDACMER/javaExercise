package java_multithreading_skills_01.com.stopThread;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/24 9:06
 */
public class MyThread extends Thread {
   /* @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }*/

   // ��ֹͣ���߳�---�쳣��  P43
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()) {
                System.out.println("�Ѿ���ֹͣ״̬�ˣ���Ҫ�Ƴ���");
                break;
            }
            System.out.println("i = " + (i + 1));
        }
    }
}
