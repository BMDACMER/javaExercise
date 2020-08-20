package ջ;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/20 20:43
 */
public class ����ˮ��̬�滮 {
    public int trap(int[] height) {
        int count = 0;
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];

        // �ҳ���ǰ����ߵ����ǽ
        for (int i = 1; i < height.length - 1; i++) {
            dpLeft[i] = Math.max(dpLeft[i-1],height[i-1]);
        }

        // �ҳ���ǰ���ұߵ����ǽ
        for (int i = height.length - 2; i >= 0; --i) {
            dpRight[i] = Math.max(dpRight[i+1],height[i+1]);
        }

        int min = Integer.MIN_VALUE;   // ��¼��ǰ����ǽ����Ǹ�
        for (int i = 1; i < height.length - 1; i++) {
            min = Math.min(dpLeft[i], dpRight[i]);
            if (height[i] < min) {
                count += min - height[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ����ˮ��̬�滮 m = new ����ˮ��̬�滮();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(m.trap(height));
    }
}
