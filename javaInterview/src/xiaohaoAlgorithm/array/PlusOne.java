package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/6 13:11
 * 66. ��һ
 */
public class PlusOne {
    /**
     * ������������ۣ�
     * 1�� ĩβ�޽�λ  98 --> 99
     * 2)  ĩβ��λ����λ�����䣩   199 --> 200
     * 3)  ĩβ��λ����λ����һλ�� 99 --> 100
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // ��Ե����������������
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9};

        int[] ans = plusOne(digits);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
