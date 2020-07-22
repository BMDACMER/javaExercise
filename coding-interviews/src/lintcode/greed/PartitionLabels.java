package lintcode.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/21 22:18
 *
 * 763. ������ĸ����
 * �������� last[char] ����ʾ�ַ� char ���һ�γ��ֵ��±ꡣ���� anchor �� j ����ʾ��ǰ�������β��
 * ����������ַ����һ�γ��ֵ�λ���±���� j�� ���� j=last[c] ����չ��ǰ�����䡣
 * ���������˵�ǰ�����ĩβʱ(�� i==j )���ѵ�ǰ�������𰸣�ͬʱ�� start ��Ϊ i+1 ȥ����һ�����䡣
 *
 * ���ߣ�LeetCode
 * ���ӣ�https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];   // ���ڴ��26����ĸ���һ�γ��ֵ�λ��
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        // ���� j �� anchor����ʾ��ǰ�������β��
        int j = 0, anchor = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            // ����������ַ����һ�γ��ֵ�λ���±���� j�� ���� j=last[c] ����չ��ǰ�����䡣
            j = Math.max(j,last[S.charAt(i) - 'a']);
            // ���������˵�ǰ�����ĩβʱ(�� i==j )���ѵ�ǰ�������𰸣�
            // ͬʱ�� start ��Ϊ i+1 ȥ����һ�����䡣
            if (i == j) {
                list.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return list;
    }
}
