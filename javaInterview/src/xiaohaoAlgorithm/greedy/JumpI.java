package xiaohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 14:23
 *
 * 55. 跳跃游戏
 */
public class JumpI {

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;  // 距离最初原点的距离
        for (int i = 0; i < nums.length - 1; i++) {
            // 不断计算能挑到的最远距离
            farthest = Math.max(farthest, nums[i] + i);
            // 可能碰到了0，卡住跳不动了
            if (farthest <= i) return false;
        }
        return farthest >= nums.length - 1;
    }
}
