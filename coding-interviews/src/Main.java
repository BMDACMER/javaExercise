import org.junit.Test;

import java.util.Scanner;

public class Main {
    @Test
    public void test1(){
        Scanner scan = new Scanner(System.in);
        int n, m;
        while (true) {
            n = scan.nextInt();
            m = scan.nextInt();
            double sum = n;
            double temp = n;
            for (int i = 1; i < m; i++) {
                sum += Math.sqrt(temp);
                temp = Math.sqrt(temp);
                System.out.println("sum_" +i +  " = " + sum);
            }
            System.out.println(String.format("%.2f",sum));
    }

    }

    @Test
    public void test2() {
        // 水仙花
        Scanner scan = new Scanner(System.in);
        int m;
        int n;
        while (true) {
            m = scan.nextInt();
            n = scan.nextInt();
            while (m > n) {
                System.out.println("请重新输入");
                m = scan.nextInt();
                n = scan.nextInt();
            }
            int count = 0;
            int[] a = new int[3];   // 用来存放三个变量
            for (int i = m; i <= n; i++) {
                a[0] = i % 10;  // 个位
                a[2] = i / 100;  // 百位
                a[1] = (i / 10) % 10;  // 十位
                if (a[0] * a[0] * a[0] + a[1] * a[1] * a[1] + a[2] * a[2] * a[2] == i) {
                    System.out.print(i + " ");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("no");
            }
        }
    }

    public static void main(String[] args) {
        int date;
        Scanner scan = new Scanner(System.in);
        date = scan.nextInt();

        int price, priceDownNum;
        priceDownNum = (int) (Math.sqrt(2*date + 0.25) - 1.5);
        price = date - 2*priceDownNum;
        System.out.println(price);
    }
}
