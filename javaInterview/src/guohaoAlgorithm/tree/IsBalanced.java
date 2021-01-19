package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 16:31
 *
 * 面试题 04.04. 检查平衡性
 */
public class IsBalanced {


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }
}
