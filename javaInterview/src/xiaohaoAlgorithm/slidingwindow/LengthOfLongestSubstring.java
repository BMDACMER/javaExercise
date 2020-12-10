package xiaohaoAlgorithm.slidingwindow;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/10 12:37
 *      ����ظ��Ӵ�
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;        //��¼���
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // ���д����ڵ�һϵ�и���
            window.put(c, window.getOrDefault(c, 0) + 1);

            // �ж���ര���Ƿ�Ҫѹ��
            while (window.get(c) > 1) {  // ȥ��
                char d = s.charAt(left);
                left++;
                // ���д��������ݵ�һϵ�и���
                window.put(d, window.get(d) - 1);
            }
            // ��������ظ��Ӵ�
            res = Math.max(res, right - left);
        }

        return res;
    }
}
