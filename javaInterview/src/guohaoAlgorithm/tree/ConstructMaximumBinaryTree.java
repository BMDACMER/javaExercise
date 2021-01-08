package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 10:56
 *
 * 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {

    /**
     * 思路：从数组中找出最大值，通过前序遍历递归构造最大二叉树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length < 1) return null;

        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        // base case
        if (start > end) return null;

        int maxVale = Integer.MIN_VALUE, index = -1;
        for (int i = start; i <= end; i++) {
            if (maxVale < nums[i]) {
                maxVale = nums[i];
                index = i;
            }
        }

        TreeNode maxNode = new TreeNode(maxVale);
        maxNode.left = build(nums, start, index - 1);
        maxNode.right = build(nums, index + 1,  end);
        return maxNode;
    }

    /**
     * 一样的方法 不同的写法   提高效率
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) return null;

        int maxValueIndex = getIndex(nums, start, end);
        int maxValue = nums[maxValueIndex];
        TreeNode root = new TreeNode(maxValue);
        root.left = constructTree(nums, start, maxValueIndex - 1);
        root.right = constructTree(nums, maxValueIndex + 1, end);
        return root;
    }

    private int getIndex(int[] nums, int start, int end) {
        int index = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                index = i;
            }
        }
        return index;
    }
}
