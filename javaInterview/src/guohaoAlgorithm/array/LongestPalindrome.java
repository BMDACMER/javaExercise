package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 20:44
 *
 * 409. 最长回文串  easy
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || "".equals(s)) return 0;
        // 因为只包含大小写字母
        int[] count = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int num : count) {
            ans += num / 2 * 2;  // ans一定是偶数
            // 下面这句最多只会执行一次，因为ans一旦为奇数后，不可能再次执行该语句
            if (num % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
