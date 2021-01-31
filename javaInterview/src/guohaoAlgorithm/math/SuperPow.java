package guohaoAlgorithm.math;

import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 15:03
 *
 * 372. �����η�
 * ��������Ǽ��� ab �� 1337 ȡģ��a ��һ����������b ��һ���ǳ�����������һ���������ʽ������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺a = 2, b = [3]
 * �����8
 */
public class SuperPow {

    /**
     * ˼�룺��Ϊ������ż��  �ݹ���ü���
     * @param a
     * @param b
     * @return
     */
    private int base = 1337;
    public int superPow(int a, int[] b) {
        if (b ==null || b.length < 1) return 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < b.length; i++) {
            list.add(b[i]);
        }

        return help(a, list);
    }

    private int help(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) return 1;

        int last = list.removeLast();
        int part1 = myPow(a, last);
        int part2 = myPow(help(a, list), 10);
        // ÿ����˶�Ҫ��Ī
        return (part1 * part2) % base;
    }

    private int myPow(int a, int k) {
        if (k == 0) return 1;
        a %= base;

        if (k % 2 == 1) {
            return (a * myPow(a, k - 1)) % base;
        } else {
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
