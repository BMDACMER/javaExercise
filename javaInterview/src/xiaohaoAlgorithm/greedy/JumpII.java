package xiaohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 14:49
 *
 * 45. ÌøÔ¾ÓÎÏ· II
 */
public class JumpII {
    /**
     *  Ì°ĞÄËã·¨   P380
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int farthest = 0;
        int end = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (end == i) {
                ans++;
                end = farthest;
            }
        }
        return ans;
    }
}
