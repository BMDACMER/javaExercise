package guohaoAlgorithm.backtrack;

import guohaoAlgorithm.list.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/30 17:10
 *
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) return res;
        LinkedList<Integer> path = new LinkedList<>();
        backtrace(n,k,1, path);
        return res;
    }

    private void backtrace(int n, int k, int i, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j <= n; j++) {
            path.add(j);
            backtrace(n, k, j + 1, path);
            path.removeLast();
        }
    }
}
