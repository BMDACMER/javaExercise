import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ��Ϊģ���⣨��̲��֣�
 * 1����a+b
 * 2���ַ���ȥ�أ��ұ���ԭ�ַ�����λ�ò���
 */
public class Main3 {
    // 2 �ַ���ȥ��
    public static void main(String[] args) {
        // ����hashSet
        Set<Character> set = null;
        Scanner in = new Scanner(System.in);
        String str = null;
        while (in.hasNext()) {
            set = new LinkedHashSet<>();
            str = in.next();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }

            // ���
            for(Character ch : set) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    // 1
    @Test
    public void testString() {
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        while (in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println((a + b));
        }
    }

}
