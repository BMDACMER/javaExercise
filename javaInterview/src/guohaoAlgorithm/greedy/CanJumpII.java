package guohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 22:24
 *
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class CanJumpII {

    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0;
        int farthest = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (end == i) {
                count++;
                end = farthest;
            }
        }
        return count;
    }
}
