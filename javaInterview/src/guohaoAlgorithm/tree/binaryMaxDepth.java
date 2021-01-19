package guohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 17:35
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class binaryMaxDepth {

    // 递归 dfs
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // bfs
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}
