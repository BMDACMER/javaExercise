package guohaoAlgorithm.math;

/**
 * @Author guohao
 * @Date 2021/3/10 11:11
 * @Version 1.0
 *
 * 171. Excel�������
 * ����һ��Excel����е������ƣ���������Ӧ������š�
 *
 * ���磬
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * ʾ�� 1:
 *
 * ����: "A"
 * ���: 1
 * ʾ�� 2:
 *
 * ����: "AB"
 * ���: 28
 * ʾ�� 3:
 *
 * ����: "ZY"
 * ���: 701
 */
public class TitleToNumber {

    // �������� 26����
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) return 0;
        char[] chars = columnTitle.toCharArray();
        int ans = chars[0] - 'A' + 1;
        for (int i = 1; i < chars.length; i++) {
            ans = ans * 26 + chars[i] - 'A' + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        TitleToNumber t = new TitleToNumber();
        System.out.println(t.titleToNumber("AB"));
    }

}
