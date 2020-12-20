package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 16:27
 */
public class SearchBST {

    /**
     * 类似于二叉树搜索
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else return root;
    }

    // 暴力解法
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode left = searchBST2(root.left, val);
        TreeNode right = searchBST2(root.right, val);
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
