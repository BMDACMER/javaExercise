package ջ;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/19 14:37
 */
public class ����ˮ {

    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);//�ҵ����ĸ߶ȣ��Ա������
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //����Ƿ�ʼ���� temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }
    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }
/*
    ���ߣ�windliang
    ���ӣ�https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    ��Դ�����ۣ�LeetCode��
    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

 */
}
