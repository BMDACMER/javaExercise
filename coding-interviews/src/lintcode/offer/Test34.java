package lintcode.offer;

public class Test34 {
    private int count = 0;
    public int NumberOf1(int n) {
        while (n!=0) {
            count++;
            n = n&(n-1);   // 统计1的个数
        }
        return count;
    }
}
