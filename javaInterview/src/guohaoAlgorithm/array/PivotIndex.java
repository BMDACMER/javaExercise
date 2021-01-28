package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 9:19
 *
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;
        // 首先计算数组所有元素之和
        int sum = 0;
        for (int num : nums) sum += num;

        // 遍历数组中的元素 // 中心索引只能是从 [1,n-2]
        int left = 0;
        for (int i = 0; i <= n - 1; i++) {
            if (i > 0) left += nums[i - 1];
            int temp = sum - nums[i];
            if (temp % 2 != 0){
                continue;
            }

            if (left == temp / 2) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex p = new PivotIndex();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(p.pivotIndex(nums));
    }
}
