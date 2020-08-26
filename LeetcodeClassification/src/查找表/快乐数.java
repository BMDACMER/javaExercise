package 查找表;

import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/26 9:18
 * 202  Happy number
 *
 * https://leetcode-cn.com/problems/happy-number/
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum;
        int temp;
        while (n != 1) {
            sum = 0;
            // 求n各位数的和
            while (n > 0) {
                temp = n % 10;
                sum += temp * temp;
                n /= 10;
            }
            // 如果求的和在过程中出现过
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            // 循环下一轮
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        快乐数 m = new 快乐数();
        System.out.println(m.isHappy(11));
    }
}
