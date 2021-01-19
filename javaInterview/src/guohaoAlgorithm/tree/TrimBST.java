package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 10:19
 */
public class TrimBST {

    /**
     * 参考： https://leetcode-cn.com/problems/trim-a-binary-search-tree/solution/xiu-jian-er-cha-sou-suo-shu-by-leetcode/
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;

        if (root.val > high) {
            // 裁掉右边
            root = root.left;
            root = trimBST(root, low, high);
        } else if (root.val < low) {
            // 裁掉左边
            root = root.right;
            root = trimBST(root, low, high);
        } else {
            // 在区间内，就去裁掉左右子节点
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
