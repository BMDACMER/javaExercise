package com.csdn.base02;

import java.util.Arrays;

public class Demo06 {

	static void testArray1() {
		int[] arr = { 1, 2, 3, 4 };
//		int array[] = {4, 5, 6};
		int[] arr2 = new int[5];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr.length);
//		System.out.println(arr[4]);
		System.out.println(arr[arr.length - 1]);

		arr2[0] = 100;
		System.out.println(arr2[0]);
		arr2[0] = 1000;
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
	}

	static void testArray2() {
		int[] a = { 1, 2, 3, 4, 5 };
		// for each
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	static void testArray3(String[] a) {
		for (String i : a) {
			System.out.print(i + " ");
		}
	}

	static String[] testArray4() {
		String[] names = { "tom", "kite", "rose" };
		return names;
	}

	static void testArray5() {
		int[] a = { 8, 6, 4, 9, 2, 5, 1, 3, 10, 7 };
		Arrays.sort(a);
//		System.out.println(a);
		for (int i : a) {
			System.out.print(i+" ");
		}

//		Arrays.sort(a);
		System.out.println("\n=====================");
		int idx = Arrays.binarySearch(a, 7);
		System.out.println(idx);
	}

	public static void main(String[] args) {
//		testArray2();
//		String[] names = {"tom", "kite", "rose"};
//		testArray3(names);
//		String[] s2 = testArray4();
//		for (String string : s2) {
//			System.out.println(string);
//		}
		testArray5();

	}

}
