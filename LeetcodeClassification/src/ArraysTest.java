/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/26 23:02
 */
public class ArraysTest {
    public static void main(String[] args) {
        A a = new A();
        B[] b = new B[100];
        b[0] = new B();
        b[1] = new B();
        b[2] = new B();
        b[3] = new B();
    }

    private static class A {
        static {
            System.out.println("A");
        }
    }

    private static class B {
        static {
            System.out.println("B");
        }
    }
}


