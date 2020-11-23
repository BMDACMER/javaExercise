package java_multithreading_skills_01.com.sleepMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 23:37
 */
public class Test2 {
    public void a() {
        b();
    }

    public void b() {
        c();
    }

    public void c() {
        d();
    }

    public void d() {
        e();
    }

    public void e() {
        StackTraceElement[] array = Thread.currentThread().getStackTrace();
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                StackTraceElement eachElement = array[i];
                System.out.println("className=" + eachElement.getClassName()
                + " methodName=" + eachElement.getMethodName() + " fileName="
                + eachElement.getFileName() + " lineName=" + eachElement.getLineNumber());
            }
        }
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        test.a();
    }

}
