package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 16:57
 * 687. 最长同值路径
 */
public class Solution12 {
    /**
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) arrowLeft += left + 1;
        if (root.right != null && root.right.val == root.val) arrowRight += right + 1;
        max = Math.max(max, arrowLeft + arrowRight);
        return max;
    }
     */

    private int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
