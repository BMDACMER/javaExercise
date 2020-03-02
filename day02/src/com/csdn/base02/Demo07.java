package com.csdn.base02;

public class Demo07 {

	static void m1() {
		int[] a = { 1, 2, 3, 4 };
		for (int i : a) {
			System.out.println(i);
		}
	}

	static void testFor() {
		int[] a = { 1, 2, 3, 4 };
		// for (int i = 0; i < a.length; i++) {
		// System.out.println(a[i]);
		// }

		// for (int i : a) {
		// System.out.println(i);
		// }
	}

	static void testWhile() {
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}

	static void testDoWhile() {
		int sum = 0;
		int i = 1;
		do {
			sum = sum + i;
			i++;
		} while (i <= 10);
		System.out.println(sum);
	}

	static void testContinue() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			} else {
				continue;
//				System.out.println("here...");
			}
		}
	}

	static void testBreak() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			} else {
				System.out.println("ÎÒÒªbreakÁË");
				break;
			}
		}
	}

	public static void main(String[] args) {
		testBreak();
			
	}
}
