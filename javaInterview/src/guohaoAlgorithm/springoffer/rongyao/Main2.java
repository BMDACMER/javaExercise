package guohaoAlgorithm.springoffer.rongyao;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/13 16:58
 *
 * �ڶ���   ��ɡ
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n != 0) {
            int c = scan.nextInt();
            int small = scan.nextInt();
            int large = scan.nextInt();
            help(c,small,large);
            n--;
        }
    }

    private static void help(int c, int small, int large) {
        // ��c������С��2ʱ ֻ��Ҫһ�˼���
        if (c <= 2) {
            System.out.println(1);
            return;
        }

        int count = 0;
        int cTmp = c;
        //��һ��
        cTmp = c - 2;
        count++;
        // ��ֹ������ ʳ��û����
        while (cTmp > 0) {
            // �ӹ�˾��c - cTmp��----��ʳ�� cTmp
            int tmp = 0;
            if (large >= (c - cTmp) * 2) {
                tmp = (c - cTmp) * 5; // ���ɽ���tmp��
                large = large - (c - cTmp);
                cTmp -= tmp;
                count += 2;
            } else {
                // �����һ��ȫ������ large  ʣ�����small������
                if (large % 2 == 0) {
                    // ʣ�����small����
                    int res = (c - cTmp) - (large / 2);
                    tmp = large * 5;
                    // �ж�small����
                    if (small >= res * 2) {
                        // ʣ���small��������  �����������˶���
                        tmp += res * 3;  // ��ʱ�ɽ�������Ϊ tmp
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                    } else if (small < res * 2) {
                        if (small % 2 == 0) tmp += small * 3;
                        else tmp += (small - 1) * 3 + 1;
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                    }
                } else {

                    // ���large ��Ϊż��
                    // ʣ�����small����
                    int res = (c - cTmp) - (large / 2);
                    tmp = (large - 1) * 5 + 2;
                    // �ж�small����
                    if (small >= res * 2) {
                        // ʣ���small��������  �����������˶���
                        tmp += res * 3;  // ��ʱ�ɽ�������Ϊ tmp
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                    } else if (small < res * 2) {
                        if (small % 2 == 0) tmp += small * 3;
                        else tmp += (small - 1) * 3 + 1;
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                        small = 0;
                    }
                }
            }

        }

        System.out.println(count);
    }
}
