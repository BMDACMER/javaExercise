package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/3/3 9:14
 * @Version 1.0
 *
 * 338. ����λ����
 * ����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 *
 * ʾ�� 1:
 *
 * ����: 2
 * ���: [0,1,1]
 * ʾ�� 2:
 *
 * ����: 5
 * ���: [0,1,1,2,1,2]
 */
public class CountBits {

    // ����һ�� �����㷨ֱ�����
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int count = 0;
            int j = i;
            while (j != 0) {
                count += j & 1;   // ��1���1 �����0
                j >>= 1;  // ����һλ
            }
            ans[i] = count;
        }
        return ans;
    }

    // �������� ��̬�滮
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i>>1] + (i&1);   //  x / 2 is x >> 1 and x % 2 is x & 1
        }
        return ans;
    }
}
