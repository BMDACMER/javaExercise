package ���ұ�;

import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/26 9:18
 * 202  Happy number
 *
 * https://leetcode-cn.com/problems/happy-number/
 */
public class ������ {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum;
        int temp;
        while (n != 1) {
            sum = 0;
            // ��n��λ���ĺ�
            while (n > 0) {
                temp = n % 10;
                sum += temp * temp;
                n /= 10;
            }
            // �����ĺ��ڹ����г��ֹ�
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            // ѭ����һ��
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        ������ m = new ������();
        System.out.println(m.isHappy(11));
    }
}
