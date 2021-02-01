package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/27 22:41
 * 213. ��ҽ��� II
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Rob2 {

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(help(nums, 0, nums.length - 2), help(nums, 1, nums.length - 1));
    }

    private int help(int[] nums, int start, int end) {
        int steal = 0, noSteal = 0;
        for (int j = start; j <= end; j++) {
            int temp = steal;
            steal = noSteal + nums[j];
            noSteal = Math.max(noSteal, temp);
        }
        return Math.max(steal, noSteal);

//        ���ߣ�sdwwld
//        ���ӣ�https://leetcode-cn.com/problems/house-robber-ii/solution/dong-tai-gui-hua-jie-jue-ji-bai-liao-100-l8ub/
//        ��Դ�����ۣ�LeetCode��
//        ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
    }

}