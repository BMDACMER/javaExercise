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
        return help(nums, 0, nums.length);


    }

    private int help(int[] nums, int i, int j) {
        // 1����ֹ������ȫ���з����
        if (nums.length < 1) return 0;
        // 2��������飬ֱ��ʣ�����һ��
        if (nums.length == 1) return nums[0];
        // 3������������
        int left = help(nums,0,nums.length/2);
        int right = help(nums, nums.length/2+1,nums.length);
        if (left == right)
            return left;
        if (solve(nums, left) > solve(nums, right)) {
            return left;
        } else {
            return right;
        }

    }

    private int solve(int[] nums, int tmp) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp == nums[i])
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
