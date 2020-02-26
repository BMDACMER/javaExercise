package day01_sort;

import java.util.Arrays;

public class Code_02_SelectionSort {

	// 选择排序
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
//				if(arr[j] < arr[minIndex]) {
//					minIndex = j;
//				}
				// 可用下面三元运算符替换
				minIndex = (arr[j] < arr[minIndex]) ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}
	
	
	// 交换两个数值 函数
//	public static void swap(int[] arr, int i, int j) {
//		arr[i] = arr[i] ^ arr[j];
//		arr[j] = arr[i] ^ arr[j];
//		arr[i] = arr[i] ^ arr[j];
//	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	/**
	 * 以下编写对数器
	 */
	// 正确的排序函数
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	//生成随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
		}
		return arr;
	}
	// 拷贝数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	// 比较数组元素
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr2.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	// 打印函数
	public static void printArray(int[] arr) {
		if (arr == null) {
			return ;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	

	// 主函数 测试
	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 50;
		int maxValue = 200;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			selectionSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "恭喜你，通过!" : "没通过，重新设计算法！");

		// 打印测试样本
		int[] arr = generateRandomArray(maxSize, maxValue);
		System.out.println("生成的数组，共有：" + arr.length + "个数");
		printArray(arr);
		selectionSort(arr);
		System.out.println("排好序的数组，共有" + arr.length + "个数");
		printArray(arr);
	
	}
}
