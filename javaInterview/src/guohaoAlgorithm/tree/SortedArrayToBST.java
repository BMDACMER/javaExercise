package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 21:15
 * <p>
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

    /**
     * 中序遍历
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int high) {
        if (left > high) return null;

        int mid = left + (high - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftRoot = build(nums, left, mid - 1);
        TreeNode rightRoot = build(nums, mid + 1, high);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}
