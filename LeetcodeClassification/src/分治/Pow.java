package 分治;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 23:07
 *
 * 50. Pow(x, n)
 * 题解： https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
 */
public class Pow {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        double res = 1.0;
        boolean isP = true;
        if (n < 0) {
            isP = false;
            n = -n;
        }

        while (n != 0) {
            if ((n&1) == 1) {  // n % 2 == 1 奇数
                res *= x;
            }
            x *= x;  // x = x^2;
            n /= 2;  // 减半
        }
        return isP?res:1/res;
    }

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(3,5));
    }
}
