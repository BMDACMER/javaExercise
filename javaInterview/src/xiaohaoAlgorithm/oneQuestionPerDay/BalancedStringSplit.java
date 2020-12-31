package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/1 0:46
 * 1221. 分割平衡字符串
 */
public class BalancedStringSplit {
    /**
     * 因为S是平衡字符串 所以S的长度为偶数
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int count = 0;
        int len = 0;  // 字串中R或L的长度
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'R') len++;
            else len--;
            if (len == 0) count++;
            index++;
        }

        return count;
    }

    public static void main(String[] args) {
        BalancedStringSplit b = new BalancedStringSplit();
        System.out.println(b.balancedStringSplit("RLRRLLRLRL"));
    }
}
