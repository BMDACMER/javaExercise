package com.csdn.base02;

public class Demo08 {

	static void testSwitch() {
		char grade = 'B';
		switch (grade) {
		case 'A':
			System.out.println("���㣡");
			break;
		case 'B':
		case 'C':
			System.out.println("���ã�");
			break;
		case 'D':
			System.out.println("һ��~");
			break;
		default:
			System.out.println("������Ҫ����Ŷ~~~");
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
			System.out.println("����10");
		} else {
			System.out.println("С��10");
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
