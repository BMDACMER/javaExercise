package lintcode.recursive;
// 110. Æ½ºâ¶þ²æÊ÷
// https://leetcode-cn.com/problems/balanced-binary-tree/
public class Solution02 {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int cntLeft = maxDepth(root.left) + 1;
        int cntRight = maxDepth(root.right) + 1;
        if (Math.abs(cntLeft-cntRight) > 1)
            result = false;
        return Math.max(cntLeft, cntRight);
    }
}
