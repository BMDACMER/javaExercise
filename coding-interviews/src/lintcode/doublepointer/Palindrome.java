package lintcode.doublepointer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/5 13:45
 */
public class Palindrome {
    public boolean validPalindrome(String s) {
        if (s.length() < 1) return false;
        int i = -1;
        int j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }


    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new Palindrome().validPalindrome(s));
    }
}
