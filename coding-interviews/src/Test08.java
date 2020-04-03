import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 考察的递归
 * 其实就是斐波那契数列
 *
 * 对于本题,前提只有 一次 1阶或者2阶的跳法。

 a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);

 b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)

 c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)

 d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2

 e.可以发现最终得出的是一个斐波那契数列
 */
public class Test08 {
    // 方法一：递归
    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    // 方法二
    public static int JumpFloor2(int target) {
        int a = 1, b = 2, c = 0;
        if (target == 1) {
            return 1;
        }else if (target == 2) {
            return 2;
        }else {
            for (int i = 3; i <= target; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            n = sc.nextInt();
//            System.out.println(JumpFloor(n));
            System.out.println(JumpFloor2(n));
        }
    }
}
