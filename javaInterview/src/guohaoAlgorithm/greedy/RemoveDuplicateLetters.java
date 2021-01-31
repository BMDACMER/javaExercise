package guohaoAlgorithm.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 21:39
 *
 * 316. ȥ���ظ���ĸ
 * ����һ���ַ��� s ������ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ��豣֤ ���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���
 *
 * ע�⣺������ 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters ��ͬ
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "bcabc"
 * �����"abc"
 * ʾ�� 2��
 *
 * ���룺s = "cbacdcbc"
 * �����"acdb"
 */
public class RemoveDuplicateLetters {

    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26]; /// 26����ĸ
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
