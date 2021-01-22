package guohaoAlgorithm.twopoint;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 15:35
 *
 * 3. ���ظ��ַ�����Ӵ�
 * medium
 */
public class LengthOfLongestSubstring {

    // �����㷨  ʱ�临�ӶȺܸ�O(n*n)
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) return 0;

        int n = s.length();
        int max = 0, len;
        Set<Character> set;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            set = new HashSet<>();
            set.add(s.charAt(i));
            while (j < n) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    j++;
                }else {
                    break;
                }
            }
            len = j - i;
            max = Math.max(max, len);
        }
        return max;
    }

    // ��������
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) return 0;
        int rk = 0;// ��ָ��  ��ʼ��ָ���һ��Ԫ��
        int n = s.length();
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));// ���ָ�������ƶ�һλ
            }
            // ���ұ������ظ�Ԫ��
            while (rk < n && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }
}
