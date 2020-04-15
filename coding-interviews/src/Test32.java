import java.util.Scanner;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有
 * 1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 */
public class Test32 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            // 一个个统计  采用暴力算法
            String str = String.valueOf(i);
            if (str.contains("1")) {
                char[] chs = str.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    if (chs[j] == '1') {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while (in.hasNextInt()) {
            n = in.nextInt();
            System.out.println(NumberOf1Between1AndN_Solution(n));
        }
    }
}
