/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和
 * "-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Test54 {
    public static boolean isNumeric(char[] str) {
        String s = new String(str);
        if (s.endsWith("f") || s.endsWith("F") || s.endsWith("d") || s.endsWith("D")) {
            return false;
        }

        try {
            Double.parseDouble(s);
        } catch (Exception e) {
           return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isNumeric("1a3.14".toCharArray()));
    }
}
