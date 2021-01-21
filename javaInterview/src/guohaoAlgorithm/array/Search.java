package guohaoAlgorithm.array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 9:51
 *
 * ������ 10.03. ������ת����
 */
public class Search {

    //  ����   ������23.28%��  ���Ǳ�������
    public int search(int[] arr, int target) {
        if (arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // ���ֲ���    ���⿼����ͼ
    public int binarySearch(int[] arr, int target) {
        /**
         *      15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14  // ����һ�����ε���������
         *      l                                       r
         *              mid
         *                                  mid
         * 1)   arr[l] == target  return l
         * 2)   arr[mid] == target   r = mid
         * 3)   if(arr[l] < arr[mid]) // ˵���ڵ�һ�� ����������   ���ֲ���
         *            if(arr[mid] < target) l = mid+1;
         *            if(arr[mid]>target) r = mid; // ����mid-1  ע��
         *            if(arr[mid] == target)  return mid;
         *     if(arr[l] > arr[mid]) // �����ַ������ұ�  ���ֲ���
         *           if(arr[mid] < target) l = mid+1;
         *           if(arr[mid] > target) r = mid;
         *           if(arr[mid] == target)  return mid;
         *     else  l++   ����
         */
        int n = arr.length;
        if (n == 0) return -1;
        int l = 0, r = n - 1;

        while (l <= r) {
            if (arr[l] == target) return l;
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                r = mid;
            }else if (arr[l] < arr[mid]) {
                // �ڵ�һ�ε���������
                if (arr[l] < target && target < arr[mid]) r = mid;
                else l = mid + 1;
            } else if (arr[l] > arr[mid]) {
                // �ڵڶ��ε���������
                if (arr[l] > target && arr[mid] < target) l = mid + 1;
                else r = mid;
            } else if (arr[l] == arr[mid]) {
                //l��mid��ȣ���������Ŀ��ֵ����l��ǰ��
                l++;
            }
        }
        return -1;
    }
}
