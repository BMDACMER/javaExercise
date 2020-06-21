package javabase;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        //1.boolean equals(int[] a,int[] b):�ж����������Ƿ���ȡ�
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,2,3,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);   // true

        //2.String toString(int[] a):���������Ϣ��
        System.out.println(Arrays.toString(arr1));   // 1 2 3 4


        //3.void fill(int[] a,int val):��ָ��ֵ��䵽����֮�С�
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));   // 10 10 10 10


        //4.void sort(int[] a):�������������
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));   // 1 2 3 4

        //5.int binarySearch(int[] a,int key)
        int[] arr3 = new int[]{-98,-34,2,34,34,34,66,79,105,210,333};
        int index = Arrays.binarySearch(arr3, 340);   // 8
        if(index >= 0){
            System.out.println(index);
        }else{
            System.out.println("δ�ҵ�");
        }
    }
}
