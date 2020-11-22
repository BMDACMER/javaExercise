package java_multithreading_skills_01.service;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 18:10
 */
public class BServer1 extends AServer implements Runnable {

    public void b_save_method() {
        System.out.println("b中保存的方法被执行");
    }

    @Override
    public void run() {
        b_save_method();
        a_save_method();
    }
}
