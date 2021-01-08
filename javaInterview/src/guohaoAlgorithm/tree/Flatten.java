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

    /**
     * 方法二：
     * 1）将左子树插到根节点的右子树，
     * 2）将右子树插到左子树的最近的右节点
     * 3）将根节点的左子树置空，根节点移到右节点上
     * 4)重复上述步骤 直到为空
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode right = root.right;

                // 找到左子树最右的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // 将左子树插到根节点的右子树位置
                root.right = root.left;
                root.left = null;
                pre.right = right;
                root = root.right;
            }
        }
    }
}
