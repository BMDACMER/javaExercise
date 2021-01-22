package guohaoAlgorithm.backtrack;

import xiaohaoAlgorithm.list.ListNode;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 19:43
 *
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Permutation {

    // 典型的回溯算法  dfs
    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        if (s == null || "".equals(s)) return null;

        int depth = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        LinkedList<Character> path = new LinkedList<>();
        dfs(chars, len, depth, path, visited);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(char[] chars, int len, int depth, LinkedList<Character> path, boolean[] visited) {
        // 终止条件
        if (len == depth) {
            StringBuilder sb = new StringBuilder(len);
            for (char c : path) {
                sb.append(c);
            }
            res.add(sb.toString());
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (visited[i] || set.contains(chars[i])) continue;
            set.add(chars[i]);
            path.add(chars[i]);
            visited[i] = true;
            dfs(chars, len, depth + 1, path, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
