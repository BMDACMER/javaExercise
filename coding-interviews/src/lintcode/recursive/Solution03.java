package lintcode.recursive;

public class Solution03 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        deepth(root);
        return max;
    }

    private int deepth(TreeNode root) {
        if (root == null) return 0;
        int cntLeft = deepth(root.left);
        int cntRight = deepth(root.right);
        max = Math.max(max, cntLeft + cntRight);
        return Math.max(cntLeft,cntRight)+1;
    }
}
