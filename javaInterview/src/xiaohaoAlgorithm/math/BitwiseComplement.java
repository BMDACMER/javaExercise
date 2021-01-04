package xiaohaoAlgorithm.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 23:14
 *
 * 1009. 十进制整数的反码
 */
public class BitwiseComplement {

    /**
     * 暴力算法  时间：27.11%
     *          内存： 67.61%
     * @param N
     * @return
     */
   /* public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        // 十进制转为二进制
        LinkedList<Integer> list = new LinkedList<>();
        int tmp;
        while (N / 2 != 0) {
            tmp = N % 2;
            N = N / 2;
            list.addFirst(tmp);
        }
        int[] arr = new int[list.size()];
        int index = 0;
        while (!list.isEmpty()) {
            if (list.pollFirst() == 1) {
                arr[index] = 0;
            }else {
                arr[index] = 1;
            }
            index++;
        }
        int ans = 0;
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            ans += arr[i] * Math.pow(2,j);
        }
        return ans;
    }*/

    /**
     * 巧劲
     * 参考：https://leetcode-cn.com/problems/complement-of-base-10-integer/
     * @param N
     * @return
     */
   public int bitwiseComplement(int N) {
        // 找到与N二进制位相同且全为1的二进制数  之后与原来的数异或运算即可得到结果
       int num = 1;
       while (num < N) {
           num = (num << 1) + 1;
       }
       return num ^ N;
   }


    public static void main(String[] args) {
        BitwiseComplement b = new BitwiseComplement();
        int ans = b.bitwiseComplement(10);
        System.out.println(ans);
    }
}
