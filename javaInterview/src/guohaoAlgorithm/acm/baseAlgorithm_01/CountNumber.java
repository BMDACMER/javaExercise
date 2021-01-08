package guohaoAlgorithm.acm.baseAlgorithm_01;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 16:57
 *
 * P1 ��������
 *
 * ���������� a �� b�������1��a��b֮����ֵĴ��������磺���a = 1024, b=1032,��ôa��b֮���������
 * 1024  1025 1026 1027 1028 1029 1030 1031 1032
 * ����10��1���ְ���Щ����
 *
 */
public class CountNumber {
    /**
     * ˼·��
     * �����x(x = 1)��0~a֮����ֵĴ����������1��0~b֮����ֵĴ���,�����������
     *
     */
    public int countX(int n, int x) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp != 0) {
                if (tmp % 10 == x)
                    count++;
                tmp /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountNumber c = new CountNumber();
        // ͳ�� [a,b]֮���1���ֵĴ���
        int a = c.countX(346, 1);
        int b = c.countX(542,1);
        System.out.println(b - a);
    }
}
