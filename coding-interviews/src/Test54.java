/**
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123","3.1416"��
 * "-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
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
