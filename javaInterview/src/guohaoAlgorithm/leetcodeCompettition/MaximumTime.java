package guohaoAlgorithm.leetcodeCompettition;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/24 10:32
 *
 * 输入：time = "1?:22"
 * 输出："19:22"
 */
public class MaximumTime {

    public String maximumTime(String time) {
        // time长度为5
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if ((chars[1] >= '0' && chars[1] <= '3' )|| chars[1] == '?')
                chars[0] = '2';
            else chars[0] = '1';
        }

        if (chars[1] == '?') {
            if (chars[0] == '2') chars[1] = '3';
            else chars[1] = '9';
        }

        if (chars[3] == '?') chars[3] = '5';
        if (chars[4] == '?') chars[4] = '9';

        return new String(chars);
    }
}
