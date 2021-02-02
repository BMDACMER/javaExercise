package guohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/2 10:54
 *
 * ��ָ Offer 20. ��ʾ��ֵ���ַ���
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100"��"5e2"��"-123"��"3.1416"��"-1E-16"��"0123"����ʾ��ֵ��
 * ��"12e"��"1a3.14"��"1.2.3"��"+-5"��"12e+5.4"�����ǡ�
 */
public class IsNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        String regex = "\\s*|([+-]?\\.?[eE][\\s\\S]*)|([+-]?\\.)";
        if (s.matches(regex)) return false;
        regex = "(([+-])?\\d*\\.?\\d*)([eE][+-]?\\d+)?";
        return s.matches(regex);
    }
}
