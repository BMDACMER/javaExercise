package lintcode.offer;

import java.util.Scanner;

/**
 * 面试题15 二进制中1的个数
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9?表示成二进制是 1001，
 * 有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
//    public static long getUnsignedIntt (int data){     //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
//        return data&0x0FFFFFFFF ;
//    }

//    public static int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//            res += n & 1;
//            n >>>= 1;   // 无符号右移
//        }
//        return res;
//    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
