package java_multithreading_skills_01.com.sleepMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 23:51
 */
public class Test3 {
    public static void main(String[] args) {
        Thread runThread = Thread.currentThread();
        System.out.println(runThread.getName() + " " + runThread.getId());  // main  1
    }
}
