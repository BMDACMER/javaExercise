package ÿ��һ��;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/19 11:09
 * 647. �����Ӵ�
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * �㷨��
 *      1���жϻ�����
 *      2������Ӵ����жϸ����Ӵ��Ƿ��ǻ�����
 */
public class �����Ӵ� {

   /* *//**
     * ������  ʱ�临�Ӷ�Ϊ O(N^3)
     *//*
    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s,i,j))
                    count++;
            }
        }
        return count;
    }

    public boolean isPalindrome(String str, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }*/

    // �����㷨���Ż�--������չ��
    // ʱ�临�Ӷȣ�O(n^2)O(n
    //�ռ临�Ӷȣ�O(n^2)O(n
    public int countSubstrings(String s) {
        int count = 0;
        /**
         * 1���� i = jʱ���ǻ��Ĵ�  �൱�ڵ����ַ�
         * 2���� s[i] = s[j] && j-i==1ʱ���൱���������ȵ��ִ�
         * 3��������չ�����������еĻ������ִ��Ƶ���һ���ִ����� s[i] = s[j] && s[j+1,i-1]Ϊ�����Ӵ�ʱ��s[i,j]Ҳ�ǻ����Ӵ�
         */
        int n = s.length();
        boolean[][] dp = new boolean[n][n];  // Ĭ��Ϊfalse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j<2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        �����Ӵ� test = new �����Ӵ�();
        System.out.println(test.countSubstrings("aaa"));
    }
}
