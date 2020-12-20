package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 17:04
 *
 * 450. 删除二叉搜索树中的节点
 */
public class DeleteNode {
    /**
     * 删除分为三种情况：
     * 1）无子节点
     * 2）一个子节点
     * 3）两个子节点
     *
     *
     * 一般来说，删除节点可分为两个步骤：
     * 1) 首先找到需要删除的节点；
     * 2) 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 找到啦  进行删除
            //情况1
            if (root.left == null && root.right == null) return null;
            // 情况2
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 情况3
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            // 去左子树查找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 去右子树查找
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMin(TreeNode root) {
        // BST最左边的就是最小的
        while (root.left != null) root = root.left;
        return root;
    }
}
