package xiaohaoAlgorithm.binarySearch;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/9 12:15
 *
 * 875. �����㽶������
 */
public class MinEatingSpeed {

    /**
     * ����Ҫ�� �������� H Сʱ�Ե������㽶����С�ٶ� K��������ľ��ǰ���Ե��ر�����ÿСʱֻ�Ե� 1 ���㽶��
     * Ȼ�������𽥵���������㽶���ٶȵ� i���պ������� H Сʱ���ԳԵ������㽶��
     * ��ʱ i ��������Ҫ�ҵ���С�ٶȡ���Ȼ������û����ô�������Կ����뵽ʹ�ö��ֵ�˼���������Ż���
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        //1 ����piles[]������   �Ͼ�������㽶���� K ����
        // �����Ե���ѵ������㽶��Ȼ����һСʱ�ڲ����ٳԸ�����㽶��
        int maxPile = 0;
        for (int num : piles)
            maxPile = Math.max(maxPile, num);

        int left = 1;
        int right = maxPile;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (canEat(piles, H, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += Math.ceil(pile * 1.0 / speed);
        }

        return sum > h;
    }
}
