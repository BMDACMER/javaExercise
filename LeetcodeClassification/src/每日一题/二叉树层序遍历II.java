package ÿ��һ��;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 9:19
 * 107. �������Ĳ�α��� II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 *
 */
public class �������������II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        // ������ȱ���
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null)
                    queue.add(left);
                if (right != null)
                    queue.add(right);
            }

            lists.add(0,level);
        }

        return lists;
    }
}
