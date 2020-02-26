package day01_sort;

import java.util.Arrays;

/**
 *  ð�����򣬲���ʹ�á��������� ��֤�Ƿ���ȷ���Ƽ�ģ�£�
 *  ʱ�临�Ӷ�Ϊ��O(N*N)
 * @author guohao
 *
 */
public class Code_00_BubbleSort {

	public static void bubbleSort(int[] arr) {
		if(arr == null || arr.length == 1) {
			return;
		}
		
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	// ��������ֵ  λ�����ٶȸ���
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j]; 
	}
	
	// ����������֤��д�㷨�Ƿ���ȷ
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	
	// ����������� ----> ���ں�����֤
	// Math.random() �������鷶ΧΪ��   [0,1)
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			// ���ɵķ�Χ[-maxValue, maxValue]
			arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
		}
		return arr;
	}
	
	// ���������飬��������
	public static int[] copyArray(int[] arr) {
		if(arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	// �ж����������Ƿ����
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	// ��ӡ����
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// ������ ���ڲ���
	public static void main(String[] args) {
		int testTime = 50000;    // ���Դ���
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			
			bubbleSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		
		// ��ӡ��������
		int[] arr = generateRandomArray(maxSize, maxValue);
		System.out.println("���ɵ����鳤��Ϊ��" + arr.length);
		printArray(arr);
		bubbleSort(arr);
		System.out.println("�ź�������飺");
		printArray(arr);
	}
}




