import java.security.cert.TrustAnchor;
import java.util.Scanner;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
public class Test12 {
    /**
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        int n = exponent;
        double sum = 1;
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为零");
            }
            exponent = -exponent;
        }

        while (exponent != 0) {
            if ((exponent & 1) == 1)
                sum *= base;
            base = base * base;
            exponent = exponent >> 1;
        }

        return n > 0 ? sum : 1 / sum;
    }

    // 方法二：  直接调API
    public double Power2(double base, int exponent) {
        double sum = 0.0;
        sum = Math.pow(base, exponent);
        return sum;
    }

    public static void main(String[] args) {
        double base;
        int exponent;
        Scanner sc = new Scanner(System.in);
        while (true) {
            base = sc.nextDouble();
            exponent = sc.nextInt();
            System.out.println(Power(base, exponent));
        }

    }
}
