package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 10:11
 *
 * �Լ��������� �����˷�
 */
public class BigNumberMultiply {

    // �������
    public String multiply(String num1, String num2) {
        // �ų��������
        if (num1 == null || "".equals(num1)) return "";
        if (num2 == null || "".equals(num2)) return "";

        // ��num1��num2תΪ�ַ�������  �����������
        char[] char1 =num1.toCharArray();
        char[] char2 = num2.toCharArray();
        // תΪint��������   ���ڼ���
        int[] n1 = new int[char1.length];
        int[] n2 = new int[char2.length];
        for (int i = 0; i < char1.length; i++) {
            n1[i] = char1[i] - '0';
        }
        for (int i = 0; i < char2.length; i++) {
            n2[i] = char2[i] - '0';
        }
        // num1 * num2 �Ľ���洢��res�У��ַ����鲻�ᳬ�� num1.length() * num2.length()
        int[] res = new int[num1.length() + num2.length()];

        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                res[i + j] += n1[i] * n2[j];
            }
        }

        //�Ӻ���ǰ��ʮ��λ
        int carry = 0;
        int curr;
        for (int i = res.length - 1; i > 0; --i) {
            curr = res[i] + carry;
            carry = curr / 10;
            curr %= 10;
            res[i] = curr;
        }
        if (carry != 0) res[0] += carry;  // ��һ�伸������ʵ�֣���Ϊ������˼�������ռ����������

        // תΪString������
        String ans = "";
        for (int i = 0; i < res.length - 1; i++) {
            ans += "" + res[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        BigNumberMultiply bm = new BigNumberMultiply();
        System.out.println(bm.multiply("10","789"));
    }

}
