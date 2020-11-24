package java_multithreading_skills_01.com.t12;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/24 23:16
 */
public class MyThread extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            i++;
        }
    }
}
