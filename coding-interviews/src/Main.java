import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/17 20:04
 */
public class Main {
    /**
     * 第一题
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int f = sc.nextInt();
//        int d = sc.nextInt();
//        int p = sc.nextInt();
//
//        int temp = d / x;
//        if (temp < f)
//            System.out.println(temp);
//        else {
//            int ret = d - x * f;
//            int totalTime = f + ret / (x + p);
//            System.out.println(totalTime);
//        }
//    }


    /**
     * 第二题
     */
    public static void main(String[] args) {
        int n;
        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while (n-- != 0) {
            arr[0] = sc.nextInt();   // n
            arr[1] = sc.nextInt();  // A
            arr[2] = sc.nextInt();   // B
            arr[3] = sc.nextInt();   // C

            if (6 * arr[0] > arr[1] + 2 * arr[2] + 3 * arr[3]) {
                System.out.println("No");
            } else {
                arr[0] -= arr[2] / 3;
                arr[0] -= arr[3] / 2;
                arr[2] %= 3;
                arr[3] %= 2;
                if (arr[0] <= 0)
                    System.out.println("Yes");
                else if (arr[0] * 6 - arr[2] * 2 - arr[3] * 3 > 0  && arr[0] * 6 - arr[2] * 2 - arr[3] * 3 <= arr[1]){
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

}
