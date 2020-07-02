package lintcode.recursive;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 10:17
 *
 * 513. 找树左下角的值
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class Solution16 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
