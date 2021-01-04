package xiaohaoAlgorithm.剑指offer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 19:39
 *
 *  剑指 Offer 20. 表示数值的字符串
 */
public class IsNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0 || s.charAt(0) == 'e' || (s.charAt(0) == '.' && s.length() == 1)
            || (s.length() > 1 && s.charAt(0) == '.' && s.charAt(1) == 'e')
            || (s.length() > 1 && s.charAt(0) == '+' && s.charAt(1) == '.')
            || (s.length() > 1 && s.charAt(0) == '-' && s.charAt(1) == '.')) {
            return false;
        }
        return s.matches("[+-]?\\d*(\\.\\d*)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        IsNumber s = new IsNumber();
        System.out.println(s.isNumber(" -."));
    }
}
