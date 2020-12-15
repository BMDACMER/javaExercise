package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/15 12:26
 *
 * 738. 单调递增的数字
 * https://leetcode-cn.com/problems/monotone-increasing-digits/solution/jian-dan-tan-xin-shou-ba-shou-jiao-xue-k-a0mp/
 */
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;

        char[] chars = String.valueOf(N).toCharArray();
        int len = chars.length;
        int lastUpIndex = 0;

        for (int i = 1; i < len; i++) {
            if (chars[i] > chars[i - 1]) {
                lastUpIndex = i;
            } else if (chars[i] < chars[i - 1]) {
                int unit = (int)Math.pow(10, len - lastUpIndex - 1);
                return N / unit * unit - 1;
            }
        }
        return N;
    }
}
