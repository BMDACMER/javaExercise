package lintcode.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/21 22:18
 *
 * 763. 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode/
 * https://leetcode-cn.com/problems/partition-labels/
 * 思想：遍历字符串中每个字符，
 *              如果字符重复截取该段字符串，遍历全程字符串的下一个字符
 *                      如果字符串不重复，接着遍历下一个字符
 *                      否则 遍历zi'fu
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
