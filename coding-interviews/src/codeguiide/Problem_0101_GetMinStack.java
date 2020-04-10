package codeguiide;

import java.util.Scanner;

/**
 * 1350. Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB

 Example1

 Input: 28
 Output: "AB"
 */
public class Problem_0101_GetMinStack {

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        while (n != 0) {
            remain = (n-1) % 26;
            n = (n - 1) / 26;
            sb.append((char)(remain+65));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        while (true) {
            n = scan.nextInt();
            System.out.println(convertToTitle(n));
        }
    }

}
