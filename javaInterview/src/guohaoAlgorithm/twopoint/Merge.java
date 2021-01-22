package guohaoAlgorithm.twopoint;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 14:37
 *
 * 面试题 10.01. 合并排序的数组
 */
public class Merge {

    // 时间复杂度为O(n)  --- 原地修改
    public void merge(int[] A, int m, int[] B, int n) {
        // 异常处理
        if (n == 0) return;

        Arrays.fill(A, m, n + m, Integer.MAX_VALUE);
        int i = 0, j = 0;
        while (i < m && j < n){
            if (A[i] <= B[j] && A[i] != Integer.MAX_VALUE) {
                i++;
            }else {
                // 将B[j]插入，把A[i]以后的元素往后移动一位
                for (int k = A.length - 1; k > i; --k) {
                    A[k] = A[k-1];
                }
                A[i] = B[j];
                i++;
                m++;
                j++;
            }
        }

        // B中的元素还没访问完
        while (j < n) {
            A[i] = B[j];
            i++;
            j++;
        }
    }

    /**
     * 方法二： 时间复杂度为O(nlogn)
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        for (int i = 0; i != n; ++i) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }

    // 方法三
    public void merge3(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            A[m + n - 1] = A[m-1] > B[n-1] ? A[--m] : B[--n];
        }
        while (n > 0) {
            A[m + n - 1] = B[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        Merge m = new Merge();
        int[] A = {0};
        int[] B = {1};
        m.merge(A,1,B,1);
    }
}
