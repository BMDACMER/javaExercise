package guohaoAlgorithm.springoffer.genshuixue;

import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 18:50
 * @Version 1.0
 *
 * 求数列的和
 *
 * （编程题须知）（参考答案）
 *
 * 时间限制： 4000MS
 * 内存限制： 557056KB
 * 题目描述：
 * 数列的定义如下： 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 *
 * 输入描述
 * 输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 *
 * 输出描述
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 *
 *
 * 样例输入
 * 81 4
 * 2 2
 *
 * 样例输出
 * 94.73
 * 3.41
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n, m;
            n = scan.nextInt();
            m = scan.nextInt();
            double sum = 0, temp = n;
            for (int i = 0; i < m; i++) {
                sum += temp;
                temp = Math.sqrt(temp);
            }
            System.out.print(String.format("%.2f", sum));
        }
    }
}
