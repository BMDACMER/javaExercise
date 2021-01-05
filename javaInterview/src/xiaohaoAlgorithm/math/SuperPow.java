package xiaohaoAlgorithm.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/5 11:30
 *
 * 372. �����η�
 */
public class SuperPow {

    int base = 1337;
    public int superPow(int a, int[] b) {
        if (b == null || b.length < 1) return 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : b) {
            list.add(num);
        }
        return myPow(a, list);
    }

    private int myPow(int a, LinkedList<Integer> list) {
        // �ݹ���õ�base
        if (list.isEmpty()) return 1;
        // ȡ���һ��Ԫ��
        int last = list.pollLast();
        int part1 = help(a,last);
        int part2 = help(myPow(a,list),10);
        // ÿ�γ˷���Ҫ��ģ
        return (part1 * part2) % base;
    }

    private int help(int a, int k) {
        int ans = 1;
        a %= base;
        while (k != 0) {
            if ((k&1) == 1){
                ans = ans * a % base;
            }
            k>>=1;
            a = a*a%base;
        }
        return ans;
    }
}
