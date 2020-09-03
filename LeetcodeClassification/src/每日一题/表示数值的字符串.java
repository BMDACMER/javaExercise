package ÿ��һ��;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/2 13:22
 * ��ָoffer20    ��ʾ��ֵ���ַ���
 */
public class ��ʾ��ֵ���ַ��� {

    public boolean isNumber(String s) {
        if (s == null || s == "")
            return false;

        return new String(s).matches("[+-]?\\d*(\\.\\d+)?[eE]?([+-]?\\d+)?");
    }

    // ������
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
        ��ʾ��ֵ���ַ��� m = new ��ʾ��ֵ���ַ���();
//        System.out.println(m.isNumber("+12e1.5"));;
        System.out.println(m.isNumeric("+12e1.5"));;
    }
}
