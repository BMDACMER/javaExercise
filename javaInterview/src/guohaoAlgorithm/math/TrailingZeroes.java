package guohaoAlgorithm.math;

/**
 * @Author guohao
 * @Date 2021/3/10 11:19
 * @Version 1.0
 *
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */
public class TrailingZeroes {

    // 数学归纳法

    /**
     * 0----4！ = 0
     * 5----9！ = 1
     * 10---14！ = 2
     * 15---19！=3
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
