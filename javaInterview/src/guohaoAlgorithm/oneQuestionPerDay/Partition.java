package guohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author guohao
 * @Date 2021/3/7 9:09
 * @Version 1.0
 *
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Partition {

    /**
     * 回溯算法    参考：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) return res;

        Deque<String> path = new ArrayDeque<>();  // 存放回文子串的路径
        char[] chars = s.toCharArray();
        dfs(chars, 0, len, path, res);

        return res;
    }

    private void dfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> res) {
        // 终止条件
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 检查是否是回文串
            if (!checkPartition(chars, index, i)) {
                continue;
            }
            path.offerLast(new String(chars, index, i - index + 1));
            dfs(chars, i + 1, len, path, res);
            path.removeLast();
        }
    }

    private boolean checkPartition(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
