package lintcode.greed;

import dataStructure.���ݽṹ���㷨֮��.Array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/10 22:31
 *
 * 455. �ַ�����
 *
 * ̰���㷨���Ƚ�g,s�ֱ������ٴ�s��ѡһ�����Ƿ�����g�е�Ԫ��
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


    // �Ż������
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
