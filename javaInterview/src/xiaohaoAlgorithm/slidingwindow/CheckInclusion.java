package xiaohaoAlgorithm.slidingwindow;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/10 10:49
 *
 *  567. �ַ���������
 */
public class CheckInclusion {

    /**
     * �ж��ַ���s���Ƿ�����Ӵ�t������
     *
     * �������еĳ�����Ȼ��һ���ģ������������ڵĴ�СʱӦ��Ϊright - left >= t.size()
     * @param s
     * @param t
     * @return
     */
    public boolean checkInclusion(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            // �������һ���
            right++;
            // �ж��ִ�t�Ƿ�����ַ�c
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // �ж��Ƿ���Ҫ�����������ǰ����ִ���ȫ���У�����������Ϊright - left >= t.length()
            while (right - left >= need.size()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s.charAt(left);
                left++;
                // ���д��������ݵ�һϵ�и���
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // δ�ҵ������������ִ�
        return false;
    }
}
