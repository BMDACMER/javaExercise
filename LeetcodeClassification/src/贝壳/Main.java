package ±´¿Ç;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/7 15:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String first, second, third, four;
        int countLeft = 0;
        int countRight = 0;
        int temp = n;
        while (n-- != 0) {
            first = sc.next();
            second = sc.next();
            third = sc.next();
            four = sc.next();

            // ×óÊÖÓ®
            if ("S".equals(first) && "J".equals(third) ||
                    "J".equals(first) && "B".equals(third) ||
                    "B".equals(first) && "S".equals(third)
            ) {
                countLeft++;
            }
            // ÓÒÊÖÓ®
            if ("S".equals(second) && "J".equals(four) ||
                    "J".equals(second) && "B".equals(four) ||
                    "B".equals(second) && "S".equals(four)) {
                countRight++;
            }

        }
        // Ö»¿¼ÂÇÓ®µÄ×´Ì¬
        if (countLeft > temp / 2 && countRight > temp / 2) {
            if (countLeft == countRight) {
                System.out.println("same");
            } else if (countLeft > countRight) {
                System.out.println("left");
            } else {
                System.out.println("right");
            }
        }



    }
}
