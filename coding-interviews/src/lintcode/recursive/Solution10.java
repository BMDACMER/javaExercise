package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 16:29
 *
 * 111. 二叉树的最小深度
 */
public class Solution10 {
    public int minDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        return (root.left == null || root.right == null) ? Math.max(left, right) + 1 : Math.min(left, right) + 1;
    }
}
