package xiaohaoAlgorithm.simulation;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 15:35
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    private TreeNode maxTree(int[] nums, int left, int right) {
        if (left > right) return null;

        int maxIndex = getMax(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxTree(nums, left, maxIndex - 1);
        root.right = maxTree(nums, maxIndex + 1, right);
        return root;
    }

    private int getMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int index = left;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
