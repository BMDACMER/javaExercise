package lintcode.offer;

/**
 * ������10- II. ������̨������
 *
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��̨�ס������������һ�� n����̨���ܹ��ж�����������

 ����Ҫȡģ 1e9+7��1000000007����������ʼ���Ϊ��1000000008���뷵�� 1��

 ��Դ�����ۣ�LeetCode��
 ���ӣ�https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Test08 {

    // ��ٷ�������  �õ���������쳲��������е�
    public int numWays(int n) {
        int a = 1, b = 2, sum;
        for (int i = 1; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
