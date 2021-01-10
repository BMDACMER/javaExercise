package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 15:23
 *
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        return traverse(root);
    }

    int sum = 0;
    private TreeNode traverse(TreeNode root) {
        if (root == null) return null;

        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
        return root;
    }
}
