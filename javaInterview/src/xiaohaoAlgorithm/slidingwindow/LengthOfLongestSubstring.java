package xiaohaoAlgorithm.slidingwindow;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/10 12:37
 *      最长无重复子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;        //记录结果
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要压缩
            while (window.get(c) > 1) {  // 去重
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 更新最长无重复子串
            res = Math.max(res, right - left);
        }

        return res;
    }
}
