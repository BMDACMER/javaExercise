package java_multithreading_skills_01.com.mythread.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 16:51
 */

/**
 * t.start(); 该行代码相当于是启动线程，
 *
 * t.run(); 该行代码相当于是使用t这个类中的run方法而已.
 *
 * 参考：https://www.cnblogs.com/whyalwaysme/p/4495959.html
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(1);
        for (int i = 0; i < 10; i++) {
            System.out.println("-------------------" + (i+1));
//            myThread.run();
            myThread.start();
            System.out.println("运行结束！");

        }
//        myThread.start();

    }
}
