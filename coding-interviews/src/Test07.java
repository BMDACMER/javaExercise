import java.util.Scanner;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 n<=39
 */
public class Test07 {
    public static int Fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1 ) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    // �ǵݹ�
    public static int Fibonacci2(int n) {
        int a = 1, b = 1, c = 0;
        if (n < 0){
            return 0;
        }else if (n == 1 || n == 2) {
            return 1;
        }else {
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true){
            n = sc.nextInt();
//            System.out.println(Fibonacci(n));
            System.out.println(Fibonacci2(n));
        }
    }

}
