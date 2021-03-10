package guohaoAlgorithm.math;

/**
 * @Author guohao
 * @Date 2021/3/10 10:23
 * @Version 1.0
 *
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    // 考察二分查找
    public int mySqrt(int x) {
        int ans = 0, l = 0, r = x;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // 借助数学方法
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans  + 1 : ans;
    }


    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        System.out.println(m.mySqrt(2147395600));
    }
}
