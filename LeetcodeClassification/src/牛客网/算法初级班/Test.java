package Å£¿ÍÍø.Ëã·¨³õ¼¶°à;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/18 21:02
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            System.out.println(isMArray(arr));
        }
    }

    public static boolean isMArray(int[] arr) {
        if (arr == null || arr.length < 3)
            return true;

        int n = arr.length;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] <= arr[i+1]) {
                count1++;
            }
            if (arr[i] >= arr[i + 1]) {
                count2++;
            }
        }
        if (count1 == n-1 || count2 == n-1)
            return true;
        return false;
    }
}
