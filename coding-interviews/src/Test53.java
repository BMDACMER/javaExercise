/**
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
 * ��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� * �ڱ����У� * ƥ����ָ�ַ�����
 * �����ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 */
public class Test53 {
    public static boolean match(char[] str, char[] pattern) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (char c : str) {
            s1.append(c);
        }
        for (char c : pattern) {
            s2.append(c);
        }
        return solve(s1.toString(),s2.toString(),0,0);
    }
    
    public static boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    /**
     *  �ַ���ƥ��
     * @param s   �ַ���1
     * @param p   �ַ���2
     * @param index1  �ַ���1 ���±�
     * @param index2   �ַ���2���±�
     * @return   ��ǰs���p��ƥ����
     */
    private static boolean solve(String s, String p, int index1, int index2) {
        // �ݹ���ֹ����1
        if (index1 == s.length()  && (index2 == p.length()  || (index2 + 1 == p.length() -1  && p.charAt(index2 + 1) == '*'))) {
            return true;
        }
        //  �ݹ���ֹ����2
        if (index1 == s.length()  || index2 == p.length()) {
            if (index1 == s.length()) {
                return change(p, index2);
            } else {
                return false;
            }
        }


        // p��ǰ�ַ�����һ��λ�õ��ַ�ʱ *
        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
            if (judge(s.charAt(index1),p.charAt(index2))) {
                return solve(s, p, index1, index2 + 2) || solve(s, p, index1 + 1, index2);
            } else {
                return solve(s, p, index1, index2 + 2);
            }
        }

        // ��ǰ�����±���ָ���ַ�ƥ��
        if (judge(s.charAt(index1), p.charAt(index2))) {
            return solve(s, p , index1 + 1, index2 + 1);
        }

        return false;
    }

    private static boolean change(String p, int index2) {
        while (index2 < p.length()) {
            if (index2 + 1 <p.length() && p.charAt(index2 + 1) == '*') {
                index2 += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param s1  �ַ�1
     * @param s2  �ַ�2
     * @return   �����ַ��Ƿ�ƥ��Ľ��
     */
    private static boolean judge(char s1, char s2) {
        if (s1 == s2 || s2 == '.') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa","ab*ac*a"));
    }
}
