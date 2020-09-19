package 剑指offer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/17 17:19
 * 剑指offer58 左转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 */
public class 左转字符串58 {
    public String reverseLeftWords(String s, int n) {
        // 方法一： 暴力法  时间复杂度为O(n)   空间复杂度为O(n)
        // 23.93%   53.85%
        /*int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = n; i < len; i++) {
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();*/

        // 方法二：用库函数
        // 100%  44.43%
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    public static void main(String[] args) {
        左转字符串58 m = new 左转字符串58();
        System.out.println(m.reverseLeftWords("abcdefg",2));
    }
}
