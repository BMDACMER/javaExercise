/**
 * ��һ�� ͳ�Ƶ�����
 * ˼·��ͳ�ƿո���+1��Ϊ���ӵĵ�������
 * ��������� ��������֮���ж���ո�ֻ����һ����ͳ��
 * �����������һ��Ϊ�ո񣬻������ҲΪ�ո����⴦�� ����ȥ�� trim()
 *
 */
public class Solution1 {
    public static int countSegments(String s) {
        // �쳣����
        if (s.length() < 1 || s == null)
            return 0;
        // ͳ�Ƶ���
        int count = 0;
         String newStr = s.trim();
         if ("".equals(newStr))
             return 0;
        for (int i = 1; i < newStr.length(); i++) {
            if (newStr.charAt(i) == ' ' &&  newStr.charAt(i - 1) != ' ') {
                count++;
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("     foo   s       "));
    }
}
