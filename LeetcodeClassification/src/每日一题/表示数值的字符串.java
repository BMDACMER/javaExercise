package 每日一题;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/2 13:22
 * 剑指offer20    表示数值的字符串
 */
public class 表示数值的字符串 {

    public boolean isNumber(String s) {
        if (s == null || s == "")
            return false;

        return new String(s).matches("[+-]?\\d*(\\.\\d+)?[eE]?([+-]?\\d+)?");
    }

    // 方法二
    public boolean isNumeric(String s) {
        if (s.isEmpty() || s.endsWith("f") || s.endsWith("F") || s.endsWith("D") || s.endsWith("d"))
            return false;
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        表示数值的字符串 m = new 表示数值的字符串();
//        System.out.println(m.isNumber("+12e1.5"));;
        System.out.println(m.isNumeric("+12e1.5"));;
    }
}
