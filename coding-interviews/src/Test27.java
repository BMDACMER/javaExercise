import java.util.*;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 *
 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
 */
public class Test27 {
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            Permutation(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    private void Permutation(char[] chars, int i, List<String> res) {

        if (i == chars.length - 1) {
            String val = String.valueOf(chars);
            if (!res.contains(val))
                res.add(val);
        }else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                Permutation(chars, i+1, res);
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
