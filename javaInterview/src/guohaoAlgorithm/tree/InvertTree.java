package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 17:24
 *
 * 226. 翻转二叉树
 */
public class InvertTree {

    /**
     * 算法思路：将左子树的节点与右子树的节点互换，采用前序or后序遍历即可
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 前序遍历
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
