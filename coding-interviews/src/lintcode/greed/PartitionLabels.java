package lintcode.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/21 22:18
 *
 * 763. 划分字母区间
 * 定义数组 last[char] 来表示字符 char 最后一次出现的下标。定义 anchor 和 j 来表示当前区间的首尾。
 * 如果遇到的字符最后一次出现的位置下标大于 j， 就让 j=last[c] 来拓展当前的区间。
 * 当遍历到了当前区间的末尾时(即 i==j )，把当前区间加入答案，同时将 start 设为 i+1 去找下一个区间。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];   // 用于存放26个字母最后一次出现的位置
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        // 定义 j 和 anchor来表示当前区间的首尾。
        int j = 0, anchor = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            // 如果遇到的字符最后一次出现的位置下标大于 j， 就让 j=last[c] 来拓展当前的区间。
            j = Math.max(j,last[S.charAt(i) - 'a']);
            // 当遍历到了当前区间的末尾时(即 i==j )，把当前区间加入答案，
            // 同时将 start 设为 i+1 去找下一个区间。
            if (i == j) {
                list.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return list;
    }
}
