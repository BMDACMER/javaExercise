package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 19:08
 *
 * 42. ����ˮ
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * �����6
 * ���ͣ������������� [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����
 *
 * ʾ�� 2��
 *
 * ���룺height = [4,2,0,3,2,5]
 * �����9
 */
public class Trap {

    // ����һ�� �����㷨 O(n^2)   ����5%���û�
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

    // �����㷨  �������   ʱ�临�Ӷ�ΪO(n^2)
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

    // �Ż��㷨  O(n)   �����ڶ�̬�滮
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

    // �Ż��ռ临�Ӷ�  ----> O(1)   ����˫ָ��ⷨ
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
