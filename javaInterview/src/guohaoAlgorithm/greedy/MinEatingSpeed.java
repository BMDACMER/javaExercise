package guohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 16:06
 *
 * 875. �����㽶������
 * ����ϲ�����㽶�������� N ���㽶���� i ������ piles[i] ���㽶�������Ѿ��뿪�ˣ����� H Сʱ�������
 *
 * ������Ծ��������㽶���ٶ� K ����λ����/Сʱ����ÿ��Сʱ��������ѡ��һ���㽶�����гԵ� K �����������㽶���� K ���������Ե���ѵ������㽶��Ȼ����һСʱ�ڲ����ٳԸ�����㽶��
 *
 * ����ϲ�������ԣ�����Ȼ���ھ�������ǰ�Ե����е��㽶��
 *
 * ������������ H Сʱ�ڳԵ������㽶����С�ٶ� K��K Ϊ��������
 *
 *
 *
 * ʾ�� 1��
 *
 * ����: piles = [3,6,7,11], H = 8
 * ���: 4
 * ʾ�� 2��
 *
 * ����: piles = [30,11,23,4,20], H = 5
 * ���: 30
 */
public class MinEatingSpeed {

    /// ˼·�������ҵ����������ģ�Ȼ����ֲ����ܷ�����ļ���  ���շ���
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for(int pile : piles) {
            int temp = pile / speed + ((pile % speed) > 0 ? 1 : 0);
            time += temp;
        }

        return time <= h;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}
