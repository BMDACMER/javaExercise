package �ֽ�����;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/14 20:41
 * 1 ����û�뵽֮�����ı༭
 * ˼·���ɵ��ظ����ε��ַ�����AABB������ ����
 */
public class ��ϰ��1 {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- != 0) {
            StringBuilder sb = new StringBuilder(sc.next());
            for (int i = 2; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1) && sb.charAt(i - 1) == sb.charAt(i - 2)) {
                    sb.deleteCharAt(i);
                    --i; // ��Ϊsb.lengthҲ����٣�����������Լ�����֤����������ȷ
                } else if (isPatten(sb, i - 3, i)) {
                    sb.deleteCharAt(i);
                    --i;
                }
            }
            System.out.println(sb.toString());
        }

    }

    private static boolean isPatten(StringBuilder sb, int n, int m) {
        if (n < 0) return false;
        return sb.charAt(n) == sb.charAt(n+1) && sb.charAt(n+2) == sb.charAt(m);
    }
}
