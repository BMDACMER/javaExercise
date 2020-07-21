package lintcode.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/21 22:18
 *
 * 763. ������ĸ����
 * https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode/
 * https://leetcode-cn.com/problems/partition-labels/
 * ˼�룺�����ַ�����ÿ���ַ���
 *              ����ַ��ظ���ȡ�ö��ַ���������ȫ���ַ�������һ���ַ�
 *                      ����ַ������ظ������ű�����һ���ַ�
 *                      ���� ����zi'fu
 */

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

}
