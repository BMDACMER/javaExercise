package guohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 15:29
 *
 * 965. µ¥Öµ¶þ²æÊ÷
 */
public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }


   // UnRescursive
    /*public boolean isUnivalTree(TreeNode root) {
        int base = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val != base) {
                return false;
            }
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        return true;
    }*/
}
