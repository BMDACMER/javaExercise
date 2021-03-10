package guohaoAlgorithm.math;

/**
 * @Author guohao
 * @Date 2021/3/10 10:23
 * @Version 1.0
 *
 * 69. x ��ƽ����
 * ʵ�� int sqrt(int x) ������
 *
 * ���㲢���� x ��ƽ���������� x �ǷǸ�������
 *
 * ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
 *
 * ʾ�� 1:
 *
 * ����: 4
 * ���: 2
 * ʾ�� 2:
 *
 * ����: 8
 * ���: 2
 * ˵��: 8 ��ƽ������ 2.82842...,
 *      ���ڷ���������������С�����ֽ�����ȥ��
 */
public class MySqrt {

    // ������ֲ���
    public int mySqrt(int x) {
        int ans = 0, l = 0, r = x;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // ������ѧ����
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans  + 1 : ans;
    }


    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        System.out.println(m.mySqrt(2147395600));
    }
}
