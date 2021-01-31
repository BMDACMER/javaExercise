package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 19:08
 *
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class Trap {

    // 方法一： 暴力算法 O(n^2)   击败5%的用户
    /*public int trap(int[] height) {
        int n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                l_max[i] = Math.max(l_max[i], height[j]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j <= n; j++) {
                r_max[i] = Math.max(r_max[i], height[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }*/

    // 暴力算法  精简代码   时间复杂度为O(n^2)
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l_max = 0, r_max = 0;
            for (int j = i; j < n; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            for (int j = i; j >= 0; j--) {
                l_max = Math.max(l_max, height[j]);
            }
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }

    // 优化算法  O(n)   类似于动态规划
    public int trap2(int[] height) {
        int n = height.length;
        int res = 0;
        int[] l_max = new int[n], r_max = new int[n];
        // base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    // 优化空间复杂度  ----> O(1)   采用双指针解法
    public int trap3(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int l_max = height[0], r_max = height[n - 1];
        int ans = 0;
        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
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
