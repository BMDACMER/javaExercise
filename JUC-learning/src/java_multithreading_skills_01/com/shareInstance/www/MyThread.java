package java_multithreading_skills_01.com.shareInstance.www;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 20:50
 */
public class MyThread extends Thread {
    private  int  count = 5;

    public MyThread(String name) {
        this.setName(name);
    }

    @Override
     public  synchronized void  run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("”… " + this.currentThread().getName() + " º∆À„£¨ count=" + count);
        }
    }
}
