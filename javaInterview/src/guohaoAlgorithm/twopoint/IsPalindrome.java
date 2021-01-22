package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 12:54
 *
 * 125. 验证回文串
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if ("".equals(s)) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
                sb.append(s.charAt(i));
        }
        for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome.isPalindrome(s));
    }
}
