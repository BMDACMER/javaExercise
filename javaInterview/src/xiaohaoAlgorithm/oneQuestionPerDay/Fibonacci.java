package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 9:43
 *
 * 509. 斐波那契数
 */
public class Fibonacci {

    /**
     * 递归
     * @param n
     * @return
     */
    /*public int fib(int n) {
        if (n==0) return 0;
        if (n == 1) return 1;
        return fib(n-1)+fib(n-2);
    }*/

    /**
     * 动态规划
     */
    public int fib(int n) {
        if (n == 0) return 0;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    /**
     * 动态规划压缩
     */
    public int fib2(int n) {
        if (n < 2) return n;
        int p1 = 0, p2 = 1, tmp;
        for (int i = 2; i < n + 1; i++) {
            tmp = p1 + p2;
            p1 = p2;
            p2 = tmp;
        }
        return p2;
    }
}
