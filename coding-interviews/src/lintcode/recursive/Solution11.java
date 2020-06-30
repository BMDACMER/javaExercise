package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 16:43
 */
public class Solution11 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode left) {
        if (left == null) return false;
        if (left.left == null && left.right == null) return true;
        else return false;
    }


}
