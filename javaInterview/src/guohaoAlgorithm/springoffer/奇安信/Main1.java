package guohaoAlgorithm.springoffer.�氲��;

import java.util.*;

/**
 * @Author guohao
 * @Date 2021/3/6 15:43
 * @Version 1.0
 */
public class Main1 {

    /**
     * ͨ�� 40%
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * ���ţ��Ͱ��
     * @param grass int����һά���� �ԵĲݵ�����
     * @param milk int����һά���� ����ţ��Ͱ��
     * @return int����
     */
    public int MaxMilk (int[] grass, int[] milk) {
        /**
         * �����ܣ�
         *    1�� �Բ���ͬ
         *    2��������ͬ
         *    3���ԵĲ��ٲ����̲�������Ƚϵ�ţ  �ȼ���  �Եö���Ķ�
         */
        if (grass == null || grass.length == 0) return 0;

        int ans = 0, n = grass.length;
        int count = milk[0];
        for (int i = 1; i < n; i++) {
            if (grass[i] == grass[i - 1] || milk[i] == milk[i - 1]) {
                count += milk[i];
            } else if (grass[i] > grass[i - 1] && milk[i] > milk[i - 1]) {
                count += milk[i];
            } else if (grass[i] < grass[i - 1] && milk[i] < milk[i - 1]) {
                count += milk[i];
            } else {
                count = milk[i];
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
