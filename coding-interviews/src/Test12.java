import java.security.cert.TrustAnchor;
import java.util.Scanner;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * <p>
 * ��֤base��exponent��ͬʱΪ0
 */
public class Test12 {
    /**
     * 1.ȫ�濼��ָ���������������Ƿ�Ϊ��������
     * 2.д��ָ���Ķ����Ʊ�����13���Ϊ������1101��
     * 3.����:10^1101 = 10^0001*10^0100*10^1000��
     * 4.ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս����
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
                throw new RuntimeException("��ĸ����Ϊ��");
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

    // ��������  ֱ�ӵ�API
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
