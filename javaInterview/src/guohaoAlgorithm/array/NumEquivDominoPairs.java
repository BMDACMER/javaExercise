package guohaoAlgorithm.array;

import javabase.thread.NumThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 8:54
 *
 * 1128. �ȼ۶���ŵ���ƶԵ�����
 *��ʽ�ϣ�dominoes[i] = [a, b]?��?dominoes[j] = [c, d]?�ȼ۵�ǰ����?a==c?��?b==d������?a==d ��?b==c��
 *
 * ��?0 <= i < j < dominoes.length?��ǰ���£��ҳ�����?dominoes[i] ��?dominoes[j]?�ȼ۵Ĺ��ƶ� (i, j) ��������
 *
 * ʾ����
 *
 * ���룺dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * �����1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int len = dominoes.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Arrays.sort(dominoes[i]);
            String key = dominoes[i][0] + "," + dominoes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int v : map.values()) {
            if (v == 0) continue;
            ans += v * (v - 1) / 2;
        }

        return ans;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumEquivDominoPairs n = new NumEquivDominoPairs();
        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(n.numEquivDominoPairs2(dominoes));
    }
}
