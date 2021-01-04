package xiaohaoAlgorithm.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 23:14
 *
 * 1009. ʮ���������ķ���
 */
public class BitwiseComplement {

    /**
     * �����㷨  ʱ�䣺27.11%
     *          �ڴ棺 67.61%
     * @param N
     * @return
     */
   /* public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        // ʮ����תΪ������
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
     * �ɾ�
     * �ο���https://leetcode-cn.com/problems/complement-of-base-10-integer/
     * @param N
     * @return
     */
   public int bitwiseComplement(int N) {
        // �ҵ���N������λ��ͬ��ȫΪ1�Ķ�������  ֮����ԭ������������㼴�ɵõ����
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
