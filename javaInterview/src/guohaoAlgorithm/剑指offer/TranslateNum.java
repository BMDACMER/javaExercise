package guohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/8 10:59
 *
 * ��ָ Offer 46. �����ַ�����ַ���
 * ����һ�����֣����ǰ������¹����������Ϊ�ַ�����0 ����� ��a�� ��1 ����� ��b����������11 ����� ��l����������25 ����� ��z����һ�����ֿ����ж�����롣����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: 12258
 * ���: 5
 * ����: 12258��5�ֲ�ͬ�ķ��룬�ֱ���"bccfi", "bwfi", "bczi", "mcfi"��"mzi"
 *
 *
 * ��ʾ��
 *
 * 0 <= num < 231
 */
public class TranslateNum {

    // �ο���https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99dnh6/
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;   // a=f(n-2)   b=f(n-1)
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i-2, i);
            int c = tmp.compareTo("10") >= 0 && tmp .compareTo("25") <= 0 ? a + b : b;
            a = b;
            b = c;
        }
        return b;
    }
}
