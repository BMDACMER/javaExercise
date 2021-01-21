package guohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 22:04
 *
 * 111. 二叉树的最小深度
 */
public class MinDepth {

   /* // 递归 -- dfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (root.left == null || root.right == null) ? Math.max(left, right) + 1 : Math.min(left, right) + 1;
    }*/

   // bfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return ans;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            ans++;
        }

        return 0;
    }
}
