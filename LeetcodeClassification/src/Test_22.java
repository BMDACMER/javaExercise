/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/26 16:31
 */
public class Test_22 {
    public static void main(String[] args) {
        Test_22_A obj = Test_22_A.getInstance();

        System.out.println(Test_22_A.val1);
        System.out.println(Test_22_A.val2);
    }
}

class Test_22_A {

    public static Test_22_A instance = new Test_22_A();
    Test_22_A() {
        val1++;
        val2++;
        System.out.println("val1 = " + val1 + "\t val2 = " + val2);
    }


    public  static int val1 = 2;   // ±»¸²¸Ç
    public  static int val2 = 0;  // ±»¸²¸Ç

    public static Test_22_A getInstance() {
        return instance;
    }
}

