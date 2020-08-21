package ��̬�滮;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 14:24
 *
 * 5. ������Ӵ�
 *
 * �����ֽⷨ----������չ
 * ���ö�̬�滮��ʽ��
 * 1)���� dp[i][j] : ��ʾ(i,j)����ִ��Ƿ��ǻ��Ĵ�
 * 2) if i - j < 2 (Ҳ����i==j || i - j == 1) ||  �� s[i] = s[j] && s[j+1,i-1]Ϊ�����Ӵ�ʱ��s[j,i]Ҳ�ǻ����Ӵ�
 *
 * �������ѣ� �����ִ�
 */
public class ����Ĵ� {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];   // Ĭ��Ϊfalse
        int maxLength = 0;
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (maxLength < s.substring(j,i+1).length()) {
                        maxLength = s.substring(j,i+1).length();
                        maxStr = s.substring(j,i+1);
                    }
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        ����Ĵ� m = new ����Ĵ�();
        System.out.println(m.longestPalindrome("bbbab"));
    }
}
