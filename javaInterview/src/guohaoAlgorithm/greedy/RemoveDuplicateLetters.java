package guohaoAlgorithm.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 21:39
 *
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 */
public class RemoveDuplicateLetters {

    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26]; /// 26个字母
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (visited[chars[i] - 'a']) continue;

            while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character character = stack.removeLast();
                visited[character - 'a'] = false;
            }
            stack.push(chars[i]);
            visited[chars[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (char c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
