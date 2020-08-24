package 动态规划;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 14:24
 *
 * 5. 最长回文子串
 *
 * 暴力分解法----中心扩展
 * 采用动态规划方式：
 * 1)定义 dp[i][j] : 表示(i,j)这个字串是否是回文串
 * 2) if i - j < 2 (也就是i==j || i - j == 1) ||  当 s[i] = s[j] && s[j+1,i-1]为回文子串时，s[j,i]也是回文子串
 *
 * 类似提醒： 回文字串
 */
public class 最长回文串 {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];   // 默认为false
        int maxLength = 0;
        String maxStr = "";
        for (int j = 0; j < s.length(); ++j) {
            for (int i = 0; i <= j; ++i) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (maxLength < s.substring(i,j+1).length()) {
                        maxLength = s.substring(i,j+1).length();
                        maxStr = s.substring(i,j+1);
                    }
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        最长回文串 m = new 最长回文串();
        System.out.println(m.longestPalindrome("bbbab"));
    }
}
