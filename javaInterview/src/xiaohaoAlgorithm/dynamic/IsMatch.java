package xiaohaoAlgorithm.dynamic;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/14 15:04
 *
 * 10. ������ʽƥ��
 */
public class IsMatch {

    /**
     * �ο�P157-161
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    HashMap<String, Boolean> memo = new HashMap<>();

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        // base case
        if (j == n)
            return i == m;
        if (i == m) {
            // �����ƥ��մ���һ�����ַ���*�ɶԳ���
            if ((n - j) % 2 == 1)
                return false;
            // ����Ƿ�Ϊx*y*z*������ʽ
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*')
                    return false;
            }
            return true;
        }

//        // ��¼״̬(i,j), �����ص�������
//        String key = i + "," + "j";
//
//        if (memo.containsKey(key)) return memo.get(key);

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // ƥ��
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // ͨ�������0�λ���
                res = dp(s, i, p, j+2) || dp(s, i+1, p, j);
            }else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // ��ƥ��
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // ͨ���ƥ�����
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        // ����ǰ�����¼����¼
//        memo.put(key, res);

        return res;
    }

}
