package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 16:08
 *
 * 1022. 从根到叶的二进制数之和
 */
public class SumRootToLeaf {

    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int tmp) {
        if (root == null) return;
        int temp = (tmp << 1) + root.val;
        if (root.left == null && root.right == null) {
            ans += temp;
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
    }
}
