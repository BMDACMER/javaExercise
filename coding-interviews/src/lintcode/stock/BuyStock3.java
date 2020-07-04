package lintcode.stock;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/4 22:47
 * <p>
 * 123. ������Ʊ�����ʱ�� III
 */
public class BuyStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int min = prices[0];            // ��ʼ����ǰ�벿����С����۸�
        int max = prices[len - 1];      // ��ʼ���ĺ�벿����������۸�

        int maxPro1 = 0;                // ǰ�벿�ֵ�ÿ���������
        int maxPro2 = 0;                // ��벿�ֵ�ÿ���������

        int[] profit1 = new int[len];   // ǰ�벿�ֵ������
        int[] profit2 = new int[len];   // ��벿�ֵ������

        for (int i = 0; i < len; i++) {

            // 1. ���� ��ǰ���� ������
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                maxPro1 = Math.max(maxPro1, prices[i] - min);
            }
            profit1[i] = maxPro1;

            //  2. ���� �Ӻ���ǰ ������
            if (prices[len - 1 - i] >= max) {
                max = prices[len - 1 - i];
            } else {
                maxPro2 = Math.max(maxPro2, max - prices[len - 1 - i]);
            }
            profit2[len - i - 1] = maxPro2;
        }

        // 3. ��������ͣ������ֵ
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, profit1[i] + profit2[i]);
        }
        return res;
    }
}


