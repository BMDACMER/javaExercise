package day01_sort;

import java.util.Arrays;

public class Code_01_InsertionSort {

	// 对数器
	// 生成随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		// 随机生成数组长度
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		// 随机生成数组中的元素[-maxValue, maxValue]
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// 拷贝数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// 判断是否相等
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

	// 写正确的排序（包括调用库函数也行）
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// 打印函数
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// 交换两个数值 函数
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	/**
	 * 插入排序 相当于从后往前数，逐个比较
	 */
	public static void insertionSort(int[] arr) {
		if (arr.length < 2 || arr == null) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

	// 主函数 main()
	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			insertionSort(arr1);
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
		insertionSort(arr);
		System.out.println("排好序的数组，共有" + arr.length + "个数");
		printArray(arr);
	}

}
