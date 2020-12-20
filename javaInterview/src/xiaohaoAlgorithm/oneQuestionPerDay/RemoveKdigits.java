package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 11:14
 * 402. 移掉K位数字
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";

        StringBuilder sb = new StringBuilder(num);
        while (k != 0) {
            int idx = 0;
            for (int i = 1; i < sb.length() && sb.charAt(i) >= sb.charAt(i - 1); i++) {
                idx = i;
            }
            sb.delete(idx, idx + 1);
            k--;
            // 处理异常数据  0开头的数字
            while (sb.length() > 1 && sb.charAt(0) == '0') sb.delete(0,1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits r = new RemoveKdigits();
        String num = "1173";
        int k = 2;
        String s = r.removeKdigits(num, k);
        System.out.println(s);
    }
}
