package com.csdn.base02;

public class Demo03 {

	public static void main(String[] args) {
		boolean flag = true;
		flag = false;
//		byte b = 128;
		byte b = 30;
		short s = 1000;
		int i = 10000;
		long l = 23232323;

		float f = 3.14F;
		double d = 3.14;

		char c = 'a';
		System.out.println((int) c);

		// 基本数据类型的封装类
		System.out.println(Byte.MIN_VALUE + "," + Byte.MAX_VALUE + "," + Byte.SIZE);
		System.out.println(Long.MIN_VALUE + "," + Long.MAX_VALUE + "," + Long.SIZE);
	}
}
