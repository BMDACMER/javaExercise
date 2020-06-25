package lintcode.offer;

/**
 *  Ҫ��ʱ�临�Ӷ�ΪO(n/2)------������
 */
public class Test35 {
    //����һ�� �ݹ�
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;   // ����Ƿ�Ϊ����
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }

        double pow = Power(base * base, exponent >> 1);
        if (exponent % 2 != 0)
            pow *= base;
        return isNegative ? 1/pow : pow;
    }

    // ��������������
//    public double myPow(double x, int n) {
//        if (n == 0) return 1;
//        long b = n;
//
//        if (b < 0) {
//            b = -b;
//            x = 1/x;
//        }
//        double res = 1.0;
//        // ������
//        while (b > 0) {
//            if ((b & 1) == 1) res *= x;
//            x *= x;
//            b >>= 1;
//        }
//
//        return res;
//    }
}
