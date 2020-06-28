package lintcode;
// https://leetcode-cn.com/problems/split-array-largest-sum/
// 410. �ָ���������ֵ---ʹ�ö��ֲ���
public class Leetcode410 {
    public int splitArray(int[] nums, int m) {
        long left = max(nums);
        long right = sum(nums);
        long middle, cnt, tmp;

        while (left < right) {
            middle =(left + right) / 2;
            cnt = 1;  // ĩβ����һ������������û��ͳ�ƣ������������ ���Գ�ʼ��������1
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
