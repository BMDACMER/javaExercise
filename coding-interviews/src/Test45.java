/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Test45 {
    public static String ReverseSentence(String str) {
        if (str.length() < 1 || str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        String tempStr = "";
        int flag = 0;  // 用来标记 "."
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
