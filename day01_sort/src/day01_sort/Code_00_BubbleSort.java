package day01_sort;

import java.util.Arrays;

/**
 *  冒泡排序，并且使用“对数器” 验证是否正确（推荐模仿）
 *  时间复杂度为：O(N*N)
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
	
	// 交换两个值  位运算速度更快
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j]; 
	}
	
	// 对数器，验证缩写算法是否正确
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	
	// 生成随机样本 ----> 便于后续验证
	// Math.random() 生成数组范围为：   [0,1)
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			// 生成的范围[-maxValue, maxValue]
			arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
		}
		return arr;
	}
	
	// 开辟新数组，用来拷贝
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
	
	// 判断两个数组是否相等
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
	
	// 打印数组
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// 主函数 用于测试
	public static void main(String[] args) {
		int testTime = 50000;    // 测试次数
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
		
		// 打印测试样本
		int[] arr = generateRandomArray(maxSize, maxValue);
		System.out.println("生成的数组长度为：" + arr.length);
		printArray(arr);
		bubbleSort(arr);
		System.out.println("排好序的数组：");
		printArray(arr);
	}
}




