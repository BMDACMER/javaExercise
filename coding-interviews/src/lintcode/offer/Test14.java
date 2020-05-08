package lintcode.offer;

import java.util.Scanner;

/**
 * ������15 ��������1�ĸ���
 *
 * ��ʵ��һ������������һ��������������������Ʊ�ʾ�� 1 �ĸ��������磬�� 9?��ʾ�ɶ������� 1001��
 * �� 2 λ�� 1����ˣ�������� 9����ú������ 2��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Test14 {

//    // you need to treat n as an unsigned value
//    public static int hammingWeight(int n) {
//        int count = 0;
//        long res = 0;
//        long temp = getUnsignedIntt(n);
//        while (temp != 0) {
//            res = temp % 2;
//            if (res == 1) {
//                count++;
//            }
//            temp /= 2;
//        }
//
//        return count;
//    }
//
//    public static long getUnsignedIntt (int data){     //��int����ת��Ϊ0~4294967295 (0xFFFFFFFF��DWORD)��
//        return data&0x0FFFFFFFF ;
//    }

//    public static int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//            res += n & 1;
//            n >>>= 1;   // �޷�������
//        }
//        return res;
//    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
