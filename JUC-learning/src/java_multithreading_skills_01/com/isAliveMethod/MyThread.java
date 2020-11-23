package java_multithreading_skills_01.com.isAliveMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 15:14
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}
