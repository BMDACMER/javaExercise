//package 栈;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/20 16:26
 */
public class Main {
    public int trap(int[] height) {
        int count = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; --j) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            int min = Math.min(maxLeft, maxRight);

            if (height[i] < min) {
                count += min - height[i];
            }
        }

        return count;
    }



    public static void main(String[] args) {
        Main m = new Main();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(m.trap(height));
    }
}
