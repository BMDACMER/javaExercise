package lintcode.offer;

/**
 * ������10- I. 쳲���������
 *
 * дһ������������ n ����쳲�������Fibonacci�����еĵ� n �쳲��������еĶ������£�

 F(0) = 0,? ?F(1)?= 1
 F(N) = F(N - 1) + F(N - 2), ���� N > 1.
 쳲����������� 0 �� 1 ��ʼ��֮���쳲�������������֮ǰ��������Ӷ��ó���

 ����Ҫȡģ 1e9+7��1000000007����������ʼ���Ϊ��1000000008���뷵�� 1��

 ��Դ�����ۣ�LeetCode��
 ���ӣ�https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Test07 {
    public int fib(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
