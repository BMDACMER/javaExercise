package lintcode.offer;

/**
 *  要求时间复杂度为O(n/2)------快速幂
 */
public class Test35 {
    //方法一： 递归
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;   // 标记是否为负数
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }

        double pow = Power(base * base, exponent >> 1);
        if (exponent % 2 != 0)
            pow *= base;
        return isNegative ? 1/pow : pow;
    }

    // 方法二：快速幂
//    public double myPow(double x, int n) {
//        if (n == 0) return 1;
//        long b = n;
//
//        if (b < 0) {
//            b = -b;
//            x = 1/x;
//        }
//        double res = 1.0;
//        // 快速幂
//        while (b > 0) {
//            if ((b & 1) == 1) res *= x;
//            x *= x;
//            b >>= 1;
//        }
//
//        return res;
//    }
}
