package 栈;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/20 20:43
 */
public class 接雨水动态规划 {
    public int trap(int[] height) {
        int count = 0;
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];

        // 找出当前列左边的最高墙
        for (int i = 1; i < height.length - 1; i++) {
            dpLeft[i] = Math.max(dpLeft[i-1],height[i-1]);
        }

        // 找出当前列右边的最高墙
        for (int i = height.length - 2; i >= 0; --i) {
            dpRight[i] = Math.max(dpRight[i+1],height[i+1]);
        }

        int min = Integer.MIN_VALUE;   // 记录当前左右墙最矮的那个
        for (int i = 1; i < height.length - 1; i++) {
            min = Math.min(dpLeft[i], dpRight[i]);
            if (height[i] < min) {
                count += min - height[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        接雨水动态规划 m = new 接雨水动态规划();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(m.trap(height));
    }
}
