package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/3/9 8:36
 * @Version 1.0
 *
 * 1047. ɾ���ַ����е����������ظ���
 * ������Сд��ĸ��ɵ��ַ��� S���ظ���ɾ��������ѡ��������������ͬ����ĸ����ɾ�����ǡ�
 *
 * �� S �Ϸ���ִ���ظ���ɾ��������ֱ���޷�����ɾ����
 *
 * ����������ظ���ɾ�������󷵻����յ��ַ������𰸱�֤Ψһ��
 *
 *
 * ʾ����
 *
 * ���룺"abbaca"
 * �����"ca"
 * ���ͣ�
 * ���磬�� "abbaca" �У����ǿ���ɾ�� "bb" ��������ĸ��������ͬ�����Ǵ�ʱΨһ����ִ��ɾ���������ظ��
 * ֮�����ǵõ��ַ��� "aaca"��������ֻ�� "aa" ����ִ���ظ���ɾ�����������������ַ���Ϊ "ca"��
 */
public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) return S;
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            sb.append(ch);
        }

        // һ�α���Stringbuilder�е��ַ��������ڵ���Ԫ���Ƴ�������curָ��ǰɾ��Ԫ�ص�ǰһ���ַ����ظ����� ֱ��������ĩβ
        int cur = 0;
        while (sb.length() >= 0 && cur < sb.length()) {
            if (cur + 1 < sb.length() && sb.charAt(cur) == sb.charAt(cur+1)) {
                sb.deleteCharAt(cur);
                sb.deleteCharAt(cur); // ɾ�������Ԫ�� ��ǰ�ƶ�һλ  ��ʱɾ������ԭ����cur+1��λ��
                if (cur > 0) cur = cur - 1;
            } else {
                cur++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        String s = "bbaca";
        System.out.println(test.removeDuplicates(s));
    }
}
