package java_multithreading_skills_01.com.myRunnable.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 18:03
 */
public class Run {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("ÔËĞĞ½áÊø£¡");
    }
}
