package lintcode.offer;

/**
 * ������16. ��ֵ�������η�
 *
 * ʵ�ֺ���double Power(double base, int exponent)����base��exponent�η���
 * ����ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 *
 */
public class Test15 {
    public static double myPow(double x, int n) {
        if (x == 0)   return 0;
        double res = 1.0;

        if (n < 0){
            n = -n;
            x = 1/x;
        }

        while (n != 0) {
            if ((n&1) != 0)
                res *= x;
            x *= x;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00,10));
    }
}
