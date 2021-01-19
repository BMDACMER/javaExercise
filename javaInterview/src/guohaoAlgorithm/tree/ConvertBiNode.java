package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 19:34
 *
 * √Ê ‘Ã‚ 17.12. BiNode
 */
public class ConvertBiNode {

    TreeNode head = new TreeNode(-1);
    TreeNode pre = null;
    public TreeNode convertBiNode(TreeNode root) {
        dfs(root);
        return head.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null) {
            pre = root;
            head.right = root;
        }else {
            pre.right = root;
            pre = pre.right;
        }
        root.left = null;
        dfs(root.right);
    }

}
