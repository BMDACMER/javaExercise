package leetcode;

public class Palindrome {
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        // ×ªÎª×Ö·û´®
//        String s = String.valueOf(x);
//        int len =s.length();
//        for (int i = 0; i < len/2; i++) {
//            if (s.charAt(i) != s.charAt(len - 1 -i)) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean isPalindrome(int x) {
//        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
//        return (x + "").equals(reversedStr);
//    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(10201));
    }
}
