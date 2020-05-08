package lintcode.offer;

/**
 * 面试题16. 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
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
