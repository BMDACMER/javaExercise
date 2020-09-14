package 字节跳动;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/14 20:41
 * 1 万万没想到之聪明的编辑
 * 思路：干掉重复三次的字符串和AABB这样的 即可
 */
public class 练习题1 {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- != 0) {
            StringBuilder sb = new StringBuilder(sc.next());
            for (int i = 2; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1) && sb.charAt(i - 1) == sb.charAt(i - 2)) {
                    sb.deleteCharAt(i);
                    --i; // 因为sb.length也会减少，所以这里得自减，保证后面自增正确
                } else if (isPatten(sb, i - 3, i)) {
                    sb.deleteCharAt(i);
                    --i;
                }
            }
            System.out.println(sb.toString());
        }

    }

    private static boolean isPatten(StringBuilder sb, int n, int m) {
        if (n < 0) return false;
        return sb.charAt(n) == sb.charAt(n+1) && sb.charAt(n+2) == sb.charAt(m);
    }
}
