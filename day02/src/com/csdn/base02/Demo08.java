package com.csdn.base02;

public class Demo08 {

	static void testSwitch() {
		char grade = 'B';
		switch (grade) {
		case 'A':
			System.out.println("优秀！");
			break;
		case 'B':
		case 'C':
			System.out.println("良好！");
			break;
		case 'D':
			System.out.println("一般~");
			break;
		default:
			System.out.println("不及格，要加油哦~~~");
			break;
		}
	}

	static void testIfElse2() {
		int a = 10;
		if (a == 20) {
			System.out.println("20");
		} else if (a == 30) {
			System.out.println("30");
		} else if (a == 40) {
			System.out.println("40");
		} else {
			System.out.println("other");
		}
	}

	static void testIfElse() {
		int i = 1;
		if (i > 10) {
			System.out.println("大于10");
		} else {
			System.out.println("小于10");
		}
	}

	static void testIf() {
		boolean flag = false;
		if (flag) {
			System.out.println("here");
		}
		System.out.println("end..");
	}

	public static void main(String[] args) {
//		testSwitch();
//		testIfElse();
//		testIfElse2();
		testIf();
	}
}
