package 分治;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 最大子序和
 */
public class 最大子序和分治法 {
    public int maxSubArray(int[] nums) {
        return maxSubArrayDivideWithBorder(nums, 0, nums.length-1);
    }

    private int maxSubArrayDivideWithBorder(int[] nums, int start, int end) {
        // 递归终止条件，只有一个元素的时候
        if (start == end) return nums[start];

        int mid = start + (end - start) / 2;
        int leftMax = maxSubArrayDivideWithBorder(nums, start, mid);
        int rightMax = maxSubArrayDivideWithBorder(nums, mid + 1, end);

        // 下面计算横跨两个子序列的最大值
        // 计算包含左侧子序列最后一个元素的子序列最大值
        int leftCrossMax = Integer.MIN_VALUE;
        int leftCrossSum = 0;
        for (int i = mid; i >= start; --i) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossMax, leftCrossSum);
        }

        // 计算包含右侧子序列最后一个元素的子序列最大值
        int rightCrossMax = nums[mid + 1];
        int rightCrossSum = 0;
        for (int i = mid + 1; i <= end; i++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossMax, rightCrossSum);
        }

        // 计算跨中心的子序列的最大值
        int crossMax = leftCrossMax + rightCrossMax;

        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        最大子序和分治法 aa = new 最大子序和分治法();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
