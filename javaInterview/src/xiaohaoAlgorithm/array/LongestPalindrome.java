package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 11:48
 * 409. 最长回文串  easy
 */
public class LongestPalindrome {

    /**
     * 时间复杂度为O(N*N)  空间复杂度为O(1)
     * 遍历每个元素，以每个元素向两端扩撒
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 寻找长度为奇数的回文字串
            String s1 = palindrome(s, i, i);
            // 寻找长度为偶数的回文字串
            String s2 = palindrome(s, i, i + 1);

            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }

        return ans;
    }

    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        int start = l + 1;
        int end = r;
        return start <= end ? s.substring(start, end) : "";
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("cbbd"));
    }
}
