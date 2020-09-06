package 贪心算法;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 10:13
 *
 * 1221. 分割平衡字符串
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 */
public class 分割平衡字符串 {
    /**
     * 此题注意点：
     *  1）给出的s一定是平衡字符串
     *  2）算法思路：
     *      当遇到"L"字符时 num++，当遇到"R"字符时 num--，当num = 0时 count++；
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                num++;
            else num--;
            if (num == 0)
                count++;
        }

        return count;
    }
}
