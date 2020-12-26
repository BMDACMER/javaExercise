package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/26 16:35
 * 42. 接雨水
 */
public class Trap {
    /**
     * 动态规划算法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] heightLeft = new int[height.length];  // 记录当前列左边最高的墙
        int[] heightRight = new int[height.length];  // 记录当前列右边最高的墙
        int result = 0;
        // 记录当前列左边最高的墙
        for (int i = 1; i < heightLeft.length - 1; i++) {
            heightLeft[i] = Math.max(heightLeft[i - 1], height[i - 1]);
        }
        // 记录当前列右边最高的墙
        for (int i = heightRight.length - 2; i > 0; i--) {
            heightRight[i] = Math.max(heightRight[i + 1], height[i + 1]);
        }

        // 比较当前列左右墙最小的高度
        for (int i = 1; i < height.length - 1; i++) {
            int dpHeight = Math.min(heightLeft[i], heightRight[i]);
            // 当前高度小于 左右墙的最小高度，可以计算出当前列所能盛下的水的容量
            if (height[i] < dpHeight) {
                result += dpHeight - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Trap t = new Trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(height));
    }
}
