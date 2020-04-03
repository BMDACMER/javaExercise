import java.util.Scanner;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 斐波那契数列
 */
public class Test10 {
    public static int RectCover(int target) {

        // 异常处理
        if (target < 1){
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    //方法二
    public static int RectCover2(int target) {

        int a = 1, b = 2, c = 0;
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
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
            System.out.println(RectCover(n));
//            System.out.println(RectCover2(n));
        }
    }
}
