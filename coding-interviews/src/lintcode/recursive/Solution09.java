package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 16:19
 *
 * 101. 对称二叉树
 */
public class Solution09 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 类似于比较两棵树是否相等
        return isSameTree(root.left,root.right);
    }

    private boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
    }
}
