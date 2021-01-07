package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 23:08
 *
 * 114. 二叉树展开为链表
 */
public class Flatten {

    /**
     * 算法思路：将左子树和右子树分别flatten  将右子树放到左子树后面  然后整个左子树作为右子树
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        /// 后续遍历位置
        // 左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2  将左子树作为右子树
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }
}
