package guohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @Author guohao
 * @Date 2021/2/27 8:46
 * @Version 1.0
 *
 * 395. 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class LongestSubstring {

    /**
     * 解题思路：
     * 1）首先统计所有字母出现的次数，如果都满足要求，直接返回字符串长度，不然，将无法满足的字符拎出来，
     *  再用于分割字符串，因为答案中肯定不能包含这些字符，答案只可能存在于这些字符的间隔之中，
     *  递归获取被分割的字符串数组，取最大值即可。
     * 2） Java中split()函数可以用来分割字符串，其中，在split中填入参数"[//a//b]"的形式就能以多种要求来分割字符串，
     * 比如这里就是分别用字符串"a"和字符串"b"来分割被分割的字符串。
     *
     * 作者：lippon
     * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/java-fen-zhi-by-lippon-n50d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if(s == null || "".equals(s) || k < 1) return 0;

        int[] count = new int[26];   // 统计各字母出现的次数
        char[] chars = s.toCharArray();
        // 统计各字符出现的次数
        for (char c : chars) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean flag = true;
        for (char c : chars) {
            if (count[c - 'a'] < k) {
                flag = false;
                sb.append("//");
                sb.append(c);
            }
        }
        sb.append("]");

        if (flag) return s.length();
        String[] strs = s.split(sb.toString());
        int res = 0;
        for (String str : strs) {
            res = Math.max(res, longestSubstring(str, k));
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        System.out.println(test.longestSubstring("abcdes", 1));
    }
}
