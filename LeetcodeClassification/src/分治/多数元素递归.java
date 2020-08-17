package ����;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:15
 */
public class ����Ԫ�صݹ� {
    /**
     * ���÷���˼�룬�ݹ�˼·��
     * 1��ȷ���зֵ���ֹ������ֱ�����е������ⶼ�ǳ���Ϊ 1 �����飬ֹͣ�з֡�
     * 2��������飬�ݹ�ؽ�ԭ�������Ϊ�������������䣬ֱ�����յ�����ֻʣ��һ��Ԫ�أ����䷵��
     * 3������������õ��ӽ�������ϲ�
     *    3.1 ����Ϊ 1 ����������Ψһ������Ȼ��������ֱ�ӷ��ؼ��ɡ�
     *    3.2 ������ǵ�������ͬ����ô��Ȼ��һ�������������������ͬ��ֵ��
     *    3.3 ������ǵ�������ͬ���Ƚ��������������������ڳ��ֵĴ��������������������
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length < 1) return 0;
        return help(nums, 0, nums.length - 1);
    }

    private int help(int[] nums, int start, int end) {
        // 1��������飬ֱ��ʣ�����һ�� һ��Ϊ����
        if (start == end) return nums[start];
        // 2������������
        int mid = start + (end - start) / 2;
        int left = help(nums,start,mid);
        int right = help(nums, mid+1,end);
        //  ������ǵ�������ͬ����ô��Ȼ��һ�������������������ͬ��ֵ��
        if (left == right)
            return left;

        // ͳ���������������
        int leftCount = countElement(nums, left, start, end);
        int rightCount = countElement(nums, right, start, end);

       return leftCount > rightCount ? left : right;
    }

    private int countElement(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (num == nums[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ����Ԫ�صݹ� aa = new ����Ԫ�صݹ�();
        int[] nums = {3,3,3,2,1};
        System.out.println(aa.majorityElement(nums));
    }
}
