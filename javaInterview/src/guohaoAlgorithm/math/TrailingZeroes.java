package guohaoAlgorithm.math;

/**
 * @Author guohao
 * @Date 2021/3/10 11:19
 * @Version 1.0
 *
 * 172. �׳˺����
 * ����һ������ n������ n! ���β�������������
 *
 * ʾ�� 1:
 *
 * ����: 3
 * ���: 0
 * ����: 3! = 6, β����û���㡣
 * ʾ�� 2:
 *
 * ����: 5
 * ���: 1
 * ����: 5! = 120, β������ 1 ����.
 */
public class TrailingZeroes {

    // ��ѧ���ɷ�

    /**
     * 0----4�� = 0
     * 5----9�� = 1
     * 10---14�� = 2
     * 15---19��=3
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
