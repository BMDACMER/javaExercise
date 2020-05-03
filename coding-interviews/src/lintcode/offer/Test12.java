package lintcode.offer;

/**
 * ������
 * <p>
 * ����һ������Ϊ n �����ӣ�������Ӽ����������ȵ� m �Σ�m��n����������n>1����m>1����
 * ÿ�����ӵĳ��ȼ�Ϊ k[0],k[1]...k[m] ������ k[0]*k[1]*...*k[m] ���ܵ����˻��Ƕ��٣�
 * ���磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Test12 {
    public int cuttingRope(int n) {
        if (n <= 3)
            return n - 1;

        int sum = 0;
        int a = n / 3, b = n % 3;
        if (b == 0)
            return (int) Math.pow(3, a);  // �պó���
        if (b == 1)
            return (int) Math.pow(3, a - 1) * 4;  // 3 *1 < 2* 2

        return (int) Math.pow(3, a) * 2;

    }
}
