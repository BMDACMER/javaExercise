package day01_sort;

import java.util.Arrays;

public class Code_01_InsertionSort {

	// ������
	// �����������
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		// ����������鳤��
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		// ������������е�Ԫ��[-maxValue, maxValue]
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// ��������
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

	// �ж��Ƿ����
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

	// д��ȷ�����򣨰������ÿ⺯��Ҳ�У�
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// ��ӡ����
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// ����������ֵ ����
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	/**
	 * �������� �൱�ڴӺ���ǰ��������Ƚ�
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

	// ������ main()
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
		System.out.println(succeed ? "��ϲ�㣬ͨ��!" : "ûͨ������������㷨��");

		// ��ӡ��������
		int[] arr = generateRandomArray(maxSize, maxValue);
		System.out.println("���ɵ����飬���У�" + arr.length + "����");
		printArray(arr);
		insertionSort(arr);
		System.out.println("�ź�������飬����" + arr.length + "����");
		printArray(arr);
	}

}
