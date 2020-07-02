package lintcode.doublepointer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 12:46
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
