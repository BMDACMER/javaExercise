/**
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 */

/**
 * ˼·�����ַ���ת��Ϊ���������Ǳ����ַ����е�ÿһ���ַ�����������������ַ������ţ����ַ��Ǹ��ţ����ַ��������ţ�
 * Ȼ�����ÿһ���ַ�����num = num * 10 + charArray[i] - '0'���ڽ����������֮ǰ������Ҫ��charArray[i]������
 * ��Ϊ�����ַ����жϣ�ѭ������ֱ����������������

 ע�����˼���㣩����1���ַ����а����з������ַ�����2���ַ����а����������ţ���3������������������
                ��4��������С�ĸ���������5�������
 ��������������������������������
 ԭ�����ӣ�https://blog.csdn.net/u013132035/article/details/80466925
 */
public class Test50 {
    public static int StrToInt(String str) {
        if (str == null || str.length() < 1)
            return 0;
        int result = 0;
        boolean negative = false;//�Ƿ���
        int i = 0, len = str.length();
        /**
         * limit Ĭ�ϳ�ʼ��Ϊ ���� ��������� �������ַ�����ʾ��������
         * ��ôresult(�ڷ���֮ǰһֱ�Ǹ�����ʽ)�ͱ���������������ĸ������Ƚϣ�
         * �ж��Ƿ����
         */
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);//���ȿ���һλ
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//�ڸ��ŵ�����£��ж������ֵ�ͱ���� ������ ��С������
                } else if (firstChar != '+')//��һλ�������ֺ�-ֻ����+
                    return 0;
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = str.charAt(i++)-'0';//charתint
                if (digit < 0 || digit > 9)//0��9���������
                    return 0;

                //�ж����
                if (result < multmin) {
                    return 0;
                }
                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //����������ͷ���-result��resultһֱ�Ǹ�����
        return negative ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("21"));
    }
}