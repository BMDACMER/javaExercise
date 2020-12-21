package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/21 10:48
 * 最小高度数
 *
 * 参考：https://leetcode-cn.com/problems/minimum-height-tree-lcci/comments/
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left == right) return null;

        int mid = left + (right - left) / 2;
        // 插入左子树
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid);
        // 插入右子树
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
