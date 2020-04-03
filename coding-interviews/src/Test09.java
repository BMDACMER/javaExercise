import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * <p>
 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。

 2）n = 1时，只有1种跳法，f(1) = 1

 3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)

 4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，

 那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)

 因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)

 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：

 f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)



 6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：

 f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)

 f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)

 可以得出：

 f(n) = 2*f(n-1)
 */
public class Test09 {
    // 方式一  递归
    public static int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }

    // 方式二  非递归
    public static int JumpFloorII2(int target) {
        int a = 0, b = 1, c = 0;
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            for (int i = 2; i <= target; i++) {
                c = 2 * b;
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
//            System.out.println(JumpFloorII(n));
            System.out.println(JumpFloorII2(n));
        }
    }
}
