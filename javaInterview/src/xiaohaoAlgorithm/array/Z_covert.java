package xiaohaoAlgorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/7 9:49
 * 6. Z 字形变换
 */
public class Z_covert {

    /*public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String[] str = new String[numRows];
        Arrays.fill(str, "");
        int n = s.length();
        //  2n-2为一个周期   i % (2n-2)   核心算法
        int period = 2 * numRows - 2;
        for (int i = 0; i < n; i++) {
            int mod = i % period;
            if (mod < numRows) {
                str[mod] += s.charAt(i);
            } else {
                str[period - mod] += s.charAt(i);
            }
        }

        // 输出
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }*/

    // 用StringBuilder效率高点
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;

        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int period = numRows * 2 - 2;
        for (int i = 0; i < s.length(); i++) {
            int mod = i % period;
            if (mod < numRows) {
                list.get(mod).append(s.charAt(i));
            } else {
                list.get(period - mod).append(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s, 3));
    }
}
