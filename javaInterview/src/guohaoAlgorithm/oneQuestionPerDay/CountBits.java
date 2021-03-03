package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/3/3 9:14
 * @Version 1.0
 *
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 */
public class CountBits {

    // 方法一： 暴力算法直接求解
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int count = 0;
            int j = i;
            while (j != 0) {
                count += j & 1;   // 有1则加1 否则加0
                j >>= 1;  // 右移一位
            }
            ans[i] = count;
        }
        return ans;
    }

    // 方法二： 动态规划
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i>>1] + (i&1);   //  x / 2 is x >> 1 and x % 2 is x & 1
        }
        return ans;
    }
}
