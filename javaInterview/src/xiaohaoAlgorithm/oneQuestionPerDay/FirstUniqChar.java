package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 14:15
 * 387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] nums = new int[26];  // 统计26个小写字母出现的次数
        Arrays.fill(nums, 0);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i] - 'a'] ++;
        }

        // 返回第一个不重复的字符的下标
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i] - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar f = new FirstUniqChar();
        System.out.println(f.firstUniqChar("loveleetcode"));
    }
}
