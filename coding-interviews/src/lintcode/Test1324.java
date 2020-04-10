package lintcode;

import java.util.Scanner;

/**
 * 计算小于非负数n的质数数。
 *   Input: n = 4
     Output: 2
     Explanation：2, 3 are prime number
 */
public class Test1324 {
    public static int countPrimes(int n) {
        // write your code here
        int count = 0;
        // n > 2
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) { // 这里相当于 6i-1和6i+1
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        while (true) {
            n = scan.nextInt();
            System.out.println(countPrimes(n));
        }
    }
}
