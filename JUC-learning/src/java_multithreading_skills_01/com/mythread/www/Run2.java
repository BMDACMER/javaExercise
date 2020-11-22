package java_multithreading_skills_01.com.mythread.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 17:23
 *
 * 使用命令分析线程的信息
 */
public class Run2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}
