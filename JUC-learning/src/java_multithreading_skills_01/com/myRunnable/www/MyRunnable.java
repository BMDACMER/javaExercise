package java_multithreading_skills_01.com.myRunnable.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 18:02
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("我是Runnable，正在运行中");
    }
}
