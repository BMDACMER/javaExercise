package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 11:07
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/submissions/
 */
public class Trap {
    /**
     * 接雨水     双指针解法  空间复杂度为O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int l_max = height[0], r_max = height[n - 1];
        int ans = 0;

        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            //  ans += min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                ans += l_max - height[left];
                left++;
            } else {
                ans += r_max - height[right];
                right--;
            }
        }

        return ans;
    }
}
