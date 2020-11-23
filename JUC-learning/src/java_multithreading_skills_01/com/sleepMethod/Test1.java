package java_multithreading_skills_01.com.sleepMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 23:25
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.currentThread().sleep(2000, 999999);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
    }
}
