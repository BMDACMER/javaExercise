package guohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/6 10:26
 *
 * ��ָ Offer 10- II. ������̨������
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��̨�ס������������һ�� n ����̨���ܹ��ж�����������
 *
 * ����Ҫȡģ 1e9+7��1000000007����������ʼ���Ϊ��1000000008���뷵�� 1��
 *
 * ʾ�� 1��
 *
 * ���룺n = 2
 * �����2
 *
 * ʾ�� 2��
 *
 * ���룺n = 7
 * �����21
 * ʾ�� 3��
 *
 * ���룺n = 0
 * �����1
 */
public class NumWays {

    public int numWays(int n) {
        int a = 1, b = 2, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    // ��̬�滮  ԭʼ��  Ч�ʵ͵�
    public int numWays2(int n) {
        if (n == 0) return 1;
        if (n == 1 || n == 2) return n;
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < n; i++) {
            nums[i] = (nums[i-1] + nums[i - 2]) % 1000_000_007;
        }
        return nums[n - 1];
    }
}
