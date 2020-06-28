package lintcode;
// https://leetcode-cn.com/problems/split-array-largest-sum/
// 410. 分割数组的最大值---使用二分查找
public class Leetcode410 {
    public int splitArray(int[] nums, int m) {
        long left = max(nums);
        long right = sum(nums);
        long middle, cnt, tmp;

        while (left < right) {
            middle =(left + right) / 2;
            cnt = 1;  // 末尾还有一个子数组我们没有统计，这里把它加上 所以初始化必须是1
            tmp = 0;
            for (Integer i : nums) {
                tmp += i;
                if (tmp > middle) {
                    tmp = i;
                    ++cnt;
                }
            }

            if (cnt > m)
                left = middle + 1;
            else
                right = middle;
        }
        return (int) left;
    }

    private int sum(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        return total;
    }

    private int max(int[] nums) {
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxVal)
                maxVal = nums[i];
        }
        return maxVal;
    }
}
