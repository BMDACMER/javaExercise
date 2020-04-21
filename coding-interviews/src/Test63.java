/**
 * 二叉搜索树的第K个结点
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 */
public class Test63 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    int count = 0;
    // 二叉搜索树中序遍历所有结点
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null)
                return node;
            count++;
            if (count == k)
                return pRoot;
            node = KthNode(pRoot.right, k);
            if (node != null)
                return node;

        }
        return null;
    }
}
