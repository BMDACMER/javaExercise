package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 16:53
 *
 * 剑指 Offer 28. 对称的二叉树
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return dfs(root.left, root.right);
        }else return true;
    }

    private boolean dfs(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;

        return dfs(L.right, R.left) && dfs(L.left, R.right);
    }
}
