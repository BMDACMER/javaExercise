package guohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author guohao
 * @Date 2021/3/7 9:09
 * @Version 1.0
 *
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class MinCut {

    /**
     * 回溯算法    参考：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
     * 超时 24/29
     * @param s
     * @return
     */
    public int minCut(String s) {
        int len = s.length();
        if (len == 0) return 0;

        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();  // 存放回文子串的路径
        char[] chars = s.toCharArray();
        /**
         * 小优化
         */
        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (chars[left] == chars[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        dfs(chars, 0, len, dp, path, res);

        int min = Integer.MAX_VALUE;
        for (List<String> str : res) {
            min = Math.min(min, str.size());
        }

        return min - 1;
    }

    private void dfs(char[] chars, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        // 终止条件
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
           if (dp[index][i]) {
               path.offerLast(new String(chars, index, i - index + 1));
               dfs(chars, i + 1, len, dp, path, res);
               path.removeLast();
           }
        }
    }

    // 参考https://leetcode-cn.com/submissions/detail/152351057/
    public int minCutII(String s) {
        int len = s.length();
        if (len < 2) return 0;
        /**
         * dp[i] 表示s[0,i]（包括索引i处的字符）符合要求的最少分割次数
         * 状态转移方程：
         * dp[i] = min(dp[j]+1 if s[j+1:i]是回文for j in range(i))
         *
         */
        int[] dp = new int[len];
        // 初始化的时候，设置称为这个最多分割次数
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }
        char[] charArray = s.toCharArray();
        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }

        // 1 个字符的时候，不用判断，因此 i 从 1 开始
        for (int i = 1; i < len; i++) {
            if (checkPalindrome[0][i]){
                dp[i] = 0;
                continue;
            }

            // 注意：这里是严格，要保证 s[j + 1:i] 至少得有一个字符串
            for (int j = 0; j < i; j++) {
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[len - 1];
    }
}
