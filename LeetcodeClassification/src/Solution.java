import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 10:18
 */
public class Solution {

    public String triCoding(int num) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

       /* // 先把num各位取出，存放到数组中
        int[] arr = new int[32];
        int index = 0;
        while (num != 0) {
            arr[index++] = num%10;
            num /= 10;
        }

        for (int i = 0; i <= index; i++) {
            while (arr[i] != 0) {
                int res = arr[i] % 3;
                sb.append(res);
                arr[i] /= 3;
            }
        }*/

        while (num != 0) {
            int res = num % 3;
            sb.append(res);
            num /= 3;
        }

        for (int i = sb.length() - 1; i >= 0; --i) {
            switch (sb.charAt(i)) {
                case '0':
                    sb2.append('@');
                    break;
                case '1':
                    sb2.append('$');
                    break;
                case '2':
                    sb2.append('&');
                    break;
            }
        }
        return sb2.toString();
    }

    public static void main(String[] args) {
        /*Solution s = new Solution();
        System.out.println(s.triCoding(123));*/

        /*Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + b);*/

        short s = 1;
//        s = s + 1;
        s += 1;
        String str = "b1";
        switch (str) {
            case "a":
                System.out.println("aaaaa");
                break;
            case "b":
                System.out.println("bbbb");
                break;
            default:
                System.out.println("default");
        }
    }
}
