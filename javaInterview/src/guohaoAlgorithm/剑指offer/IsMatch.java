package guohaoAlgorithm.��ָoffer;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/7 10:18
 *
 * ��ָ Offer 19. ������ʽƥ��
 * ��ʵ��һ����������ƥ�����'. '��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ���0�Σ����ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬����"aa.a"��"ab*a"����ƥ�䡣
 *
 * ʾ�� 1:
 *
 * ����:
 * s = "aa"
 * p = "a"
 * ���: false
 * ����: "a" �޷�ƥ�� "aa" �����ַ�����
 * ʾ�� 2:
 *
 * ����:
 * s = "aa"
 * p = "a*"
 * ���: true
 * ����: ��Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        return help(s, 0, p, 0);
    }

    HashMap<String, Boolean> memo = new HashMap<>();
    private boolean help(String s, int i, String p, int j) {
        // base case
        int m = s.length(), n = p.length();
        // ���ģʽ�� ƥ�����  ��s���Ƿ�ƥ�����
        if (j == n) {
            return i == m;
        }
        // ���s��ƥ����ϣ���ģʽ���Ƿ�ƥ�����
        if (i == m) {
            // ���p ûƥ�����  һ���Ǻ�*�ɶԳ��ֵ�
            if ((n - j) % 2 == 1) return false;
            // ����Ƿ�Ϊ x*y*z* ������ʽ
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*')
                    return false;
            }
            return true;
        }

        // ��¼״̬(i,j),�����ظ�������
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // ƥ��0�κͶ��
                res = help(s, i, p, j + 2) || help(s, i + 1, p, j);
            } else {
                // ����ƥ��  ���ƶ�һλ
                res = help(s, i + 1, p, j + 1);
            }
        }else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // ƥ��0��
                res = help(s, i, p, j + 2);
            } else {
                // ���治ƥ��
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
