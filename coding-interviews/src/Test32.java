import java.util.Scanner;

/**
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������
 * 1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�
 * ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�����
 */
public class Test32 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            // һ����ͳ��  ���ñ����㷨
            String str = String.valueOf(i);
            if (str.contains("1")) {
                char[] chs = str.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    if (chs[j] == '1') {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while (in.hasNextInt()) {
            n = in.nextInt();
            System.out.println(NumberOf1Between1AndN_Solution(n));
        }
    }
}
