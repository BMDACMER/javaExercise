/**
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ��
 * ��һ������Fish������������ȴ������������˼�����磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
 * ��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class Test45 {
    public static String ReverseSentence(String str) {
        if (str.length() < 1 || str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        String tempStr = "";
        int flag = 0;  // ������� "."
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '.') {
                tempStr += str.charAt(i);
            } else if (str.charAt(i) != '.') {
                tempStr = reverse(tempStr);
                sb.append(tempStr);
                if (flag == 1) {
                    sb.append(".");
                    flag = 0;
                }
                sb.append(" ");

                tempStr = "";
            } else {
                flag = 1;
            }

        }
        tempStr = reverse(tempStr);
        sb.append(tempStr);
        return sb.toString();
    }

    private static String reverse(String tempStr) {
        if (tempStr.length() <= 1) {
            return tempStr;
        }
        char[] chars = tempStr.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am a student."));
    }

}
