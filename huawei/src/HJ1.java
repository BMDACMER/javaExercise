import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/10 14:48
 *
 * HJ1 �����ַ������һ�����ʵĳ��ȣ������Կո������
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&&tqId=21224&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class HJ1 {
    // ���ַ���ת��Ϊ�ַ����飬�� �ո� �з�
    private static int str2Array(String s) {
        String[] str = s.split(" ");
        String temp = "";
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("")) {
                temp = str[i];
            }
        }
        return temp.length();
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            System.out.println(str2Array(s));
        }
    }
}
