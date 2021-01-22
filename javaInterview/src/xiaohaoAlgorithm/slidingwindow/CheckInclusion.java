package xiaohaoAlgorithm.slidingwindow;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/10 10:49
 *
 *  567. 字符串的排列
 */
public class CheckInclusion {

    /**
     * 判断字符串s中是否包含子串t的排列
     *
     * 由于排列的长度显然是一样的，所以收缩窗口的大小时应该为right - left >= t.size()
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
            // 窗口向右滑动
            right++;
            // 判断字串t是否包含字符c
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否需要收缩，由于是包含字串的全排列，所以条件改为right - left >= t.length()
            while (right - left >= need.size()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 未找到符合条件的字串
        return false;
    }
}
