package guohaoAlgorithm.twopoint;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 14:37
 *
 * ������ 10.01. �ϲ����������
 */
public class Merge {

    // ʱ�临�Ӷ�ΪO(n)  --- ԭ���޸�
    public void merge(int[] A, int m, int[] B, int n) {
        // �쳣����
        if (n == 0) return;

        Arrays.fill(A, m, n + m, Integer.MAX_VALUE);
        int i = 0, j = 0;
        while (i < m && j < n){
            if (A[i] <= B[j] && A[i] != Integer.MAX_VALUE) {
                i++;
            }else {
                // ��B[j]���룬��A[i]�Ժ��Ԫ�������ƶ�һλ
                for (int k = A.length - 1; k > i; --k) {
                    A[k] = A[k-1];
                }
                A[i] = B[j];
                i++;
                m++;
                j++;
            }
        }

        // B�е�Ԫ�ػ�û������
        while (j < n) {
            A[i] = B[j];
            i++;
            j++;
        }
    }

    /**
     * �������� ʱ�临�Ӷ�ΪO(nlogn)
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        for (int i = 0; i != n; ++i) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }

    // ������
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
