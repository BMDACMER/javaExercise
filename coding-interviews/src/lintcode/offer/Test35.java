package lintcode.offer;

/**
 *  Ҫ��ʱ�临�Ӷ�ΪO(n/2)
 */
public class Test35 {
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
}
