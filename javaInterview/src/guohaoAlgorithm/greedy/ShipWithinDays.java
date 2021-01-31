package guohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 17:53
 *
 * 1011. �� D �����ʹ����������
 * ���ʹ��ϵİ��������� D ���ڴ�һ���ۿ����͵���һ���ۿڡ�
 *
 * ���ʹ��ϵĵ� i ������������Ϊ weights[i]��ÿһ�죬���Ƕ��ᰴ����������˳�������ʹ���װ�ذ���������װ�ص��������ᳬ�������������������
 *
 * �������� D ���ڽ����ʹ��ϵ����а����ʹ�Ĵ����������������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * �����15
 * ���ͣ�
 * ����������� 15 ���ܹ��� 5 �����ʹ����а�����������ʾ��
 * �� 1 �죺1, 2, 3, 4, 5
 * �� 2 �죺6, 7
 * �� 3 �죺8
 * �� 4 �죺9
 * �� 5 �죺10
 *
 * ��ע�⣬������밴�ո�����˳��װ�ˣ����ʹ����������Ϊ 14 �Ĵ���������װ�ֳ� (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) �ǲ�����ġ�
 */
public class ShipWithinDays {

    // ���Ը���koko���㽶 ����   ���ֲ���+̰��
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights), right = getSum(weights);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }

    private boolean canFinish(int[] weights, int d, int cap) {
        int i = 0;
        for (int day = 0; day < d; day++) {
            int maxCap = cap;
            while ((maxCap -= weights[i]) >= 0) {
                i++;
                if (i == weights.length)
                    return true;
            }
        }
        return false;
    }

    private int getMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for(int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }
}
