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
 * 131. �ָ���Ĵ�
 * ����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
 *
 * ���� s ���п��ܵķָ����
 *
 * ʾ��:
 *
 * ����: "aab"
 * ���:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Partition {

    /**
     * �����㷨    �ο���https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) return res;

        Deque<String> path = new ArrayDeque<>();  // ��Ż����Ӵ���·��
        char[] chars = s.toCharArray();
        dfs(chars, 0, len, path, res);

        return res;
    }

    private void dfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> res) {
        // ��ֹ����
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // ����Ƿ��ǻ��Ĵ�
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
