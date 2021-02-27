package guohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @Author guohao
 * @Date 2021/2/27 8:46
 * @Version 1.0
 *
 * 395. ������K���ظ��ַ�����Ӵ�
 * �ҵ������ַ�������Сд�ַ���ɣ��е���Ӵ� T �� Ҫ�� T �е�ÿһ�ַ����ִ����������� k ����� T �ĳ��ȡ�
 *
 * ʾ�� 1:
 *
 * ����:
 * s = "aaabb", k = 3
 *
 * ���:
 * 3
 *
 * ��Ӵ�Ϊ "aaa" ������ 'a' �ظ��� 3 �Ρ�
 * ʾ�� 2:
 *
 * ����:
 * s = "ababbc", k = 2
 *
 * ���:
 * 5
 *
 * ��Ӵ�Ϊ "ababb" ������ 'a' �ظ��� 2 �Σ� 'b' �ظ��� 3 �Ρ�
 */
public class LongestSubstring {

    /**
     * ����˼·��
     * 1������ͳ��������ĸ���ֵĴ��������������Ҫ��ֱ�ӷ����ַ������ȣ���Ȼ�����޷�������ַ��������
     *  �����ڷָ��ַ�������Ϊ���п϶����ܰ�����Щ�ַ�����ֻ���ܴ�������Щ�ַ��ļ��֮�У�
     *  �ݹ��ȡ���ָ���ַ������飬ȡ���ֵ���ɡ�
     * 2�� Java��split()�������������ָ��ַ��������У���split���������"[//a//b]"����ʽ�����Զ���Ҫ�����ָ��ַ�����
     * ����������Ƿֱ����ַ���"a"���ַ���"b"���ָ�ָ���ַ�����
     *
     * ���ߣ�lippon
     * ���ӣ�https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/java-fen-zhi-by-lippon-n50d/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if(s == null || "".equals(s) || k < 1) return 0;

        int[] count = new int[26];   // ͳ�Ƹ���ĸ���ֵĴ���
        char[] chars = s.toCharArray();
        // ͳ�Ƹ��ַ����ֵĴ���
        for (char c : chars) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean flag = true;
        for (char c : chars) {
            if (count[c - 'a'] < k) {
                flag = false;
                sb.append("//");
                sb.append(c);
            }
        }
        sb.append("]");

        if (flag) return s.length();
        String[] strs = s.split(sb.toString());
        int res = 0;
        for (String str : strs) {
            res = Math.max(res, longestSubstring(str, k));
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        System.out.println(test.longestSubstring("abcdes", 1));
    }
}
