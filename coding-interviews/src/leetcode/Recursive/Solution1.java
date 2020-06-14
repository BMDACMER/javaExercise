package leetcode.Recursive;
// https://leetcode-cn.com/explore/orignial/card/recursion-i/256/principle-of-recursion/1198/
//
public class Solution1 {
    public static String reverseString(char[] s) {
        return new StringBuilder(new String(s)).reverse().toString();
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(reverseString(s));
    }
}
