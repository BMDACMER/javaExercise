package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/27 22:41
 * 213. 打家劫舍 II
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
        /*int steal = 0, noSteal = 0;
        for (int j = start; j <= end; j++) {
            int temp = steal;
            steal = noSteal + nums[j];
            noSteal = Math.max(noSteal, temp);
        }
        return Math.max(steal, noSteal);*/
        if (end - start <= 0) return nums[start];
        int dp_1 = nums[start], dp_2 = Math.max(nums[start], nums[start + 1]), dp_i = dp_2;
        for (int i = start + 2; i <= end; i++) {
            dp_i = Math.max(dp_1 + nums[i], dp_2);
            dp_1 = dp_2;
            dp_2 = dp_i;
        }
        return dp_i;

//        作者：sdwwld
//        链接：https://leetcode-cn.com/problems/house-robber-ii/solution/dong-tai-gui-hua-jie-jue-ji-bai-liao-100-l8ub/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
