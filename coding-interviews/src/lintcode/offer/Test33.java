package lintcode.offer;

/**
 * ��ֹ���
 * ���ţ� 3 �������� n ���ܲ�Ϊ������� 3 ����������Ϊ 0,1,2 ���������
 * ���ţ� 2 ��������Ϊ 22 �����������ٲ�Ϊ 1+1��
 * �� 1 ��������Ϊ 11 ����Ӧ��һ�� 3 + 1 �滻Ϊ 2 + 2����Ϊ 2��2>3��1��
 * <p>
 * ���ߣ�jyd
 * ���ӣ�https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
public class Test33 {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0)
            return (int) Math.pow(3, n / 3);
        if (n % 3 == 1)
            return (int) Math.pow(3, n / 3 - 1) * 4;
        // if (n % 3 == 2)
        return (int) Math.pow(3, n / 3) * 2;

    }
}
