package java_multithreading_skills_01.com.t12;

import com.sun.jmx.snmp.internal.SnmpSubSystem;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/24 23:17
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(5000);

            // A ¶Î
            thread.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i=" + thread.getI());

            // B ¶Î
            thread.resume();
            Thread.sleep(5000);

            // c¶Î
            thread.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i=" + thread.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
