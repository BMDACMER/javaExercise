package ����;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 ��������
 */
public class �������ͷ��η� {
    public int maxSubArray(int[] nums) {
        return maxSubArrayDivideWithBorder(nums, 0, nums.length-1);
    }

    private int maxSubArrayDivideWithBorder(int[] nums, int start, int end) {
        // �ݹ���ֹ������ֻ��һ��Ԫ�ص�ʱ��
        if (start == end) return nums[start];

        int mid = start + (end - start) / 2;
        int leftMax = maxSubArrayDivideWithBorder(nums, start, mid);
        int rightMax = maxSubArrayDivideWithBorder(nums, mid + 1, end);

        // ������������������е����ֵ
        // �������������������һ��Ԫ�ص����������ֵ
        int leftCrossMax = Integer.MIN_VALUE;
        int leftCrossSum = 0;
        for (int i = mid; i >= start; --i) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossMax, leftCrossSum);
        }

        // ��������Ҳ����������һ��Ԫ�ص����������ֵ
        int rightCrossMax = nums[mid + 1];
        int rightCrossSum = 0;
        for (int i = mid + 1; i <= end; i++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossMax, rightCrossSum);
        }

        // ��������ĵ������е����ֵ
        int crossMax = leftCrossMax + rightCrossMax;

        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        �������ͷ��η� aa = new �������ͷ��η�();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
