package 贪心算法;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/5 22:30
 *
 * 55 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int rightmost = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
