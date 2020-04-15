import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 华为模拟题（编程部分）
 * 1、求a+b
 * 2、字符串去重，且保持原字符串的位置不变
 */
public class Main3 {
    // 2 字符串去重
    public static void main(String[] args) {
        // 采用hashSet
        Set<Character> set = null;
        Scanner in = new Scanner(System.in);
        String str = null;
        while (in.hasNext()) {
            set = new LinkedHashSet<>();
            str = in.next();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }

            // 输出
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
