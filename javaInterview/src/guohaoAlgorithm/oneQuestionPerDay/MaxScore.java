package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/6 8:56
 *
 * 1423. �ɻ�õ�������
 * ���ſ��� �ų�һ�У�ÿ�ſ��ƶ���һ����Ӧ�ĵ������������������� cardPoints ������
 *
 * ÿ���ж�������Դ��еĿ�ͷ����ĩβ��һ�ſ��ƣ���������������� k �ſ��ơ�
 *
 * ��ĵ����������õ����е����п��Ƶĵ���֮�͡�
 *
 * ����һ���������� cardPoints ������ k�����㷵�ؿ��Ի�õ���������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺cardPoints = [1,2,3,4,5,6,1], k = 3
 * �����12
 * ���ͣ���һ���ж��������������ƣ���ĵ������� 1 �����ǣ��������ұߵĿ��ƽ��������Ŀɻ�õ��������Ų��������ұߵ������ƣ����յ���Ϊ 1 + 6 + 5 = 12 ��
 * ʾ�� 2��
 *
 * ���룺cardPoints = [2,2,2], k = 2
 * �����4
 * ���ͣ����������������ſ��ƣ��ɻ�õĵ������� 4 ��
 */
public class MaxScore {

    /**
     * ����ʣ�࿨���������ģ�ʹ��һ���̶�����Ϊ n-kn?k �Ļ������ڶ�����cardPoints ���б�����
     * �������������Сֵ��Ȼ�������п��Ƶĵ���֮�ͼ�ȥ����Сֵ�����õ������߿��Ƶ���֮�͵����ֵ��
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/solution/ke-huo-de-de-zui-da-dian-shu-by-leetcode-7je9/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        // 1 <= k <= cardPoints.length
        if (cardPoints == null || cardPoints.length == 0 || k == 0) return 0;

        int window = cardPoints.length - k;   // ��Ϊ�������ģ��ҳ���С�ͼ���
        int sum = 0;
        for (int i = 0; i < window; i++) {
            sum += cardPoints[i];
        }
        int min = sum;
        for (int i = window; i < cardPoints.length; i++) {
            sum += cardPoints[i] - cardPoints[i - window];
            min = Math.min(min, sum);
        }

        return Arrays.stream(cardPoints).sum() - min;
    }
}
