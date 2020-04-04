import java.util.Scanner;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Test11 {
    /**
     * 方法一  n做与运算 后 直接成为了二进制
     * 设置flag=1 和 n进行与运算，从右到左以此进行，直到flag为最大数 超过了21亿就归零 跳出循环
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;  // 统计1的个数
        int flag = 1;    // 进行与运算
        while (flag != 0) {
            if ((n&flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 方法二 (推荐)
    public static int NumberOf12(int n){
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();

            System.out.println(NumberOf1(n));
        }
    }
}
