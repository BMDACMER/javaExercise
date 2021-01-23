package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 20:44
 *
 * 409. ����Ĵ�  easy
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * ����:
 * "abccccdd"
 *
 * ���:
 * 7
 *
 * ����:
 * ���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || "".equals(s)) return 0;
        // ��Ϊֻ������Сд��ĸ
        int[] count = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int num : count) {
            ans += num / 2 * 2;  // ansһ����ż��
            // ����������ֻ��ִ��һ�Σ���Ϊansһ��Ϊ�����󣬲������ٴ�ִ�и����
            if (num % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
