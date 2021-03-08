package guohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author guohao
 * @Date 2021/3/7 9:09
 * @Version 1.0
 *
 * 131. �ָ���Ĵ�
 * ����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
 *
 * ���� s ���п��ܵķָ����
 *
 * ʾ��:
 *
 * ����: "aab"
 * ���:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class MinCut {

    /**
     * �����㷨    �ο���https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
     * ��ʱ 24/29
     * @param s
     * @return
     */
    public int minCut(String s) {
        int len = s.length();
        if (len == 0) return 0;

        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();  // ��Ż����Ӵ���·��
        char[] chars = s.toCharArray();
        /**
         * С�Ż�
         */
        // Ԥ����
        // ״̬��dp[i][j] ��ʾ s[i][j] �Ƿ��ǻ���
        boolean[][] dp = new boolean[len][len];
        // ״̬ת�Ʒ��̣��� s[i] == s[j] ��ʱ��dp[i][j] �ο� dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // ע�⣺left <= right ȡ�Ⱥű�ʾ 1 ���ַ���ʱ��Ҳ��Ҫ�ж�
            for (int left = 0; left <= right; left++) {
                if (chars[left] == chars[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        dfs(chars, 0, len, dp, path, res);

        int min = Integer.MAX_VALUE;
        for (List<String> str : res) {
            min = Math.min(min, str.size());
        }

        return min - 1;
    }

    private void dfs(char[] chars, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        // ��ֹ����
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
           if (dp[index][i]) {
               path.offerLast(new String(chars, index, i - index + 1));
               dfs(chars, i + 1, len, dp, path, res);
               path.removeLast();
           }
        }
    }

    // �ο�https://leetcode-cn.com/submissions/detail/152351057/
    public int minCutII(String s) {
        int len = s.length();
        if (len < 2) return 0;
        /**
         * dp[i] ��ʾs[0,i]����������i�����ַ�������Ҫ������ٷָ����
         * ״̬ת�Ʒ��̣�
         * dp[i] = min(dp[j]+1 if s[j+1:i]�ǻ���for j in range(i))
         *
         */
        int[] dp = new int[len];
        // ��ʼ����ʱ�����ó�Ϊ������ָ����
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }
        char[] charArray = s.toCharArray();
        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }

        // 1 ���ַ���ʱ�򣬲����жϣ���� i �� 1 ��ʼ
        for (int i = 1; i < len; i++) {
            if (checkPalindrome[0][i]){
                dp[i] = 0;
                continue;
            }

            // ע�⣺�������ϸ�Ҫ��֤ s[j + 1:i] ���ٵ���һ���ַ���
            for (int j = 0; j < i; j++) {
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[len - 1];
    }
}
