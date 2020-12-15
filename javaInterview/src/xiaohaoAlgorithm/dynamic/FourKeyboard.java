package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/15 9:34
 * 651	 4键键盘
 *
 * 参考：P165-167
 */
public class FourKeyboard {
    /**
     * dp[i]---操作i次后屏幕上最多dp[i]个A
     * @param n
     * @return
     */
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;  // 按A键，就比上一次多一个A而已
            // 按C-V，穷举按完C-A  C-C的时机
            for (int j = 2; j < i; j++) {
                // 如果此时按完C-A   C-C的话
                // 第i次按键盘时，剪贴板中A的数量为dp[i - 2]
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N次按键之后最多有几个A？
        return dp[n];
    }
}
