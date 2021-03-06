package guohaoAlgorithm.剑指offer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/8 10:59
 *
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 */
public class TranslateNum {

    // 参考：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99dnh6/
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;   // a=f(n-2)   b=f(n-1)
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i-2, i);
            int c = tmp.compareTo("10") >= 0 && tmp .compareTo("25") <= 0 ? a + b : b;
            a = b;
            b = c;
        }
        return b;
    }
    // 官方解答  标准的动态规划问题
    public int translateNum2(int num) {
        String s = Integer.toString(num);
        int len = s.length();
        if (len < 2) return len;

        char[] chars = s.toCharArray();
        // dp[i] --- 表示下标为[0,i)的前i个元素能翻译成小写字母的种数
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i + 1] = dp[i];
            int currentNum = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[len];
    }
}
