package guohaoAlgorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 8:17
 *
 * 989. ������ʽ�������ӷ�
 */
public class AddToArrayForm {

    // ���ô����ӷ� ��� --- ����5%����
    /*List<Integer> res = new ArrayList<>();
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        if (n == 0) return res;
        // ����תΪ�������
        String str1 = "";
        for (int i = 0; i < n; i++) {
            str1 += A[i];
        }
        String str2 = String.valueOf(K);
        String ans = bigNumberAdd(str1, str2);
        System.out.println(ans);
        char[] chars = ans.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res.add(chars[i] - '0');
        }
        return res;
    }

    private String bigNumberAdd(String str1, String str2) {
        if (str1 == null || "".equals(str1)) return str2;
        if (str2 == null || "".equals(str2)) return str1;
        int maxLen = Math.max(str1.length(), str2.length());
        int minLen = Math.min(str1.length(), str2.length());
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();
        StringBuilder result = new StringBuilder(maxLen + 1);// ���һλ�洢��λ��Ԫ��
        int index = 0;  // ������������ַ���
        int carry = 0;// �洢��λ
        int curr; // ��ǰֵ
        while (index < minLen) {
            curr = str1.charAt(index) + str2.charAt(index) - 2 * '0' + carry;
            carry = curr/10;
            curr %= 10;
            result.append(curr);
            index++;
        }
        if (str1.length() < str2.length()) {
            str1 = str2;
        }
        while (index < str1.length()) {
            curr = str1.charAt(index) - '0' + carry;
            carry = curr / 10;
            curr %= 10;
            result.append(curr);
            index++;
        }
        //�������һ���Ľ�λ(��ѭ���������ǲ��ǻ����ܻ���һ����λ)
        if (carry > 0) result.append(carry);
        return result.reverse().toString();
    }*/

    // �������� ��Ա�����㷨
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int curr;
        for (int i = n - 1; i >= 0; --i) {
            curr = A[i] + K % 10 + carry;
            K /= 10;
            carry = curr / 10;
            curr %= 10;
            res.add(curr);
        }

        while (K != 0) {
            curr = K % 10 + carry;
            K /= 10;
            carry = curr / 10;
            curr %= 10;
            res.add(curr);
        }

        if (carry > 0) res.add(carry);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        AddToArrayForm a = new AddToArrayForm();
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        System.out.println(a.addToArrayForm(A, 1));
    }
}
