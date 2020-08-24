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
        for (int j = 0; j < s.length(); ++j) {
            for (int i = 0; i <= j; ++i) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (maxLength < s.substring(i,j+1).length()) {
                        maxLength = s.substring(i,j+1).length();
                        maxStr = s.substring(i,j+1);
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
