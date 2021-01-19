package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 14:54
 *
 * 938. 二叉搜索树的范围和
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int ans = 0;
        if (root.val > high) {
            // 节点数大于右边界，就把右节点全部剪掉
            root = root.left;
            // 裁剪后，继续看左节点
            ans = rangeSumBST(root, low, high);
        } else if (root.val < low) {
            // 节点数小于左边界，把左节点全部剪掉
            root = root.right;
            // 裁剪后，继续看右节点
            ans = rangeSumBST(root, low, high);
        }else {
            // 这里的节点值在[low, high]区间内，
            int left = rangeSumBST(root.left, low, high);
            int right = rangeSumBST(root.right, low, high);
            // 将左右子树的节点值和当前节点值全部累加到ans上即可
            ans = left+right+root.val;
        }

        return ans;
    }
}
