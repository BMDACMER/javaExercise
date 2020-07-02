package lintcode.recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 9:22
 * 637. 二叉树的层平均值
 * <p>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
public class Solution15 {
    Queue<TreeNode> queue = new LinkedList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;
        queue.add(root);
        ArrayList<Double> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            int cntLevel = cnt;
            double sum = 0.0;
            while (cnt-- != 0) {
                TreeNode t = queue.poll();
                sum += t.val;
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
            }
            list.add(sum / cntLevel);
        }
        return list;
    }
}
