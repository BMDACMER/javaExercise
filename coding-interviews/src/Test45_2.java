/**
 * ���㷽��  �ο� https://www.nowcoder.com/profile/921406/codeBookDetail?submissionId=1517066
 */
public class Test45_2 {

    public String ReverseSentence(String str) {
        // ����ֻ��һ�����ʵ��ַ���
        if (str.trim().equals("")) {
            return str;
        }
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
