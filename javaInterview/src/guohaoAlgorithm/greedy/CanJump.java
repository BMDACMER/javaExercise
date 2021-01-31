package guohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 22:23
 *
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int farthest = 0;  // 距离最初原点的距离
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest <= i) return false;
        }
        return farthest >= nums.length - 1;
    }
}
