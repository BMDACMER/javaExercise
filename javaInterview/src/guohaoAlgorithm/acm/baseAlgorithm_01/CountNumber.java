package guohaoAlgorithm.acm.baseAlgorithm_01;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 16:57
 *
 * P1 计数问题
 *
 * 给定两个数 a 和 b，计算出1在a和b之间出现的次数。例如：如果a = 1024, b=1032,那么a和b之间的数就是
 * 1024  1025 1026 1027 1028 1029 1030 1031 1032
 * 则有10个1出现哎这些数中
 *
 */
public class CountNumber {
    /**
     * 思路：
     * 先求出x(x = 1)在0~a之间出现的次数，在求出1在0~b之间出现的次数,两者相减即可
     *
     */
    public int countX(int n, int x) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp != 0) {
                if (tmp % 10 == x)
                    count++;
                tmp /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountNumber c = new CountNumber();
        // 统计 [a,b]之间的1出现的次数
        int a = c.countX(346, 1);
        int b = c.countX(542,1);
        System.out.println(b - a);
    }
}
