package 每日一题;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/19 11:09
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 算法：
 *      1）判断回文数
 *      2）拆分子串，判断各个子串是否是回文数
 */
public class 回文子串 {

   /* *//**
     * 暴力法  时间复杂度为 O(N^3)
     *//*
    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s,i,j))
                    count++;
            }
        }
        return count;
    }

    public boolean isPalindrome(String str, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }*/

    // 暴力算法的优化--中心扩展法
    // 时间复杂度：O(n^2)O(n
    //空间复杂度：O(n^2)O(n
    public int countSubstrings(String s) {
        int count = 0;
        /**
         * 1）当 i = j时，是回文串  相当于单个字符
         * 2）当 s[i] = s[j] && j-i==1时，相当于奇数长度的字串
         * 3）中心扩展法，根据已有的回文数字串推到下一个字串，当 s[i] = s[j] && s[j+1,i-1]为回文子串时，s[i,j]也是回文子串
         */
        int n = s.length();
        boolean[][] dp = new boolean[n][n];  // 默认为false
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j<2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        回文子串 test = new 回文子串();
        System.out.println(test.countSubstrings("aaa"));
    }
}
