package lintcode.greed;

import dataStructure.数据结构与算法之美.Array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/10 22:31
 *
 * 455. 分发饼干
 *
 * 贪心算法：先将g,s分别排序，再从s中选一个看是否满足g中的元素
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            j = count;
            while (j < g.length) {
                if (s[i] >= g[j]){
                    count++;
                    break;
                }
                j++;
            }
        }
        return count;
    }


    // 优化后代码
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        AssignCookies a = new AssignCookies();
        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{5,6,7,8};
        System.out.println(a.findContentChildren(g,s));
    }
}
