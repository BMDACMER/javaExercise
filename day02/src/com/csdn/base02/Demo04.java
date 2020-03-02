package com.csdn.base02;

public class Demo04 {

	// 三元运算 e1 ? e2 : e3
	static void testTerm() {
		// 假设修正法
		int max;
		int x = 100, y = 30;
		if (x > y) {
			max = x;
		} else {
			max = y;
		}
		System.out.println(max);

		max = (x > y) ? x : y;
		System.out.println(max);

		int a = 999999, b = 1000, c = 2000;

		if (a > b) {
			max = a;
			if (c > a) {
				max = c;
			}
		} else {
			max = b;
			if (c > b) {
				max = c;
			}
		}
		System.out.println(max);

		max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println(max);
	}

	// 自增自减
	// 自增（++）：将变量的值加1，分前缀式（如++i）和后缀式（如i++）。前缀式是先加1再使用；后缀式是先使用再加1。
	// 自减（--）：将变量的值减1，分前缀式（如--i）和后缀式（如i--）。前缀式是先减1再使用；后缀式是先使用再减1。
	static void testAPP() {
		int i = 0;
		int j = i++;
		System.out.println("i=" + i);
		System.out.println("j=" + j);
		int k = --i;
		System.out.println("i=" + i);
		System.out.println("j=" + j);
		System.out.println("k=" + k);
	}

	// 赋值运算 =
	static void testAssign() {
		// 1. 简单赋值
		int x = 1; // 常量
		int y = x; // 变量
		int z = x + y; // 表达式
		int s = Math.max(1, 2); // 方法返回值等等

		// 2. 复合赋值 自身运算
		int a = 100;
		a += 10; // a = a + 10;
		System.out.println("a=" + a);
		a -= 10; // a = a -10
		System.out.println("a=" + a);
		a *= 10;
		System.out.println("a=" + a);
		a /= 10;
		System.out.println("a=" + a);
	}

	// 逻辑运算 & | ! && ||
	static void testLogic() {
		final int HEIGHT = 185;
		final int WEIGHT = 75;
		final int MONEY = 10000000;

		int h = 165;
		int w = 100;
		int m = 20000000;
		boolean result;

//			& | ! and or not

		result = h >= HEIGHT & w <= WEIGHT & m >= MONEY;
		System.out.println(result);

		result = h >= HEIGHT | w <= WEIGHT | m >= MONEY;
		System.out.println(result);

		boolean flag = false;
		System.out.println(!flag);

		// && 如果前面的表达式可以确定结果 后面的表达式将不再计算

		int a = 1, b = 2, c = 3;

		if (a > b && c++ > 10) {
			System.out.println("run");
		}
		System.out.println(c);

		// 短路或
		if (a < b || c++ > 10) {
			System.out.println("run...");
		}
		System.out.println(c);
	}

	// 关系运算 > >= < <= == !=
	static void testRelation() {
		// 基本类型的比较
		int a = (int) (Math.random() * 100);
		int b = (int) (Math.random() * 100);

		System.out.println("a=" + a);
		System.out.println("b=" + b);

		boolean result;
		result = a > b;
		System.out.println("a>b:" + result);
		result = a >= b;

		System.out.println("a>=b:" + result);
		result = a < b;

		System.out.println("a<b:" + result);

		result = a <= b;
		System.out.println("a<=b:" + result);

		result = a == b;
		System.out.println("a==b:" + result);

		result = a != b;
		System.out.println("a!=b:" + result);

	}
	
	// 算术运算 + - * / %
	static void testMath() {
		int a = (int) (Math.random() * 100);
		int b = (int) (Math.random() * 100);
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);

		int result;
		result = a + b;
		System.out.println("a+b=" + result);
		result = a - b;
		System.out.println("a-b=" + result);
		result = a * b;
		System.out.println("a*b=" + result);
		result = a / b; // 结果取整
		System.out.println("a/b=" + result);
		result = a % b;
		System.out.println("a%b=" + result);
		// 被0除
		int x = 0, y = 20;
		// int r = y / x;
		// System.out.println(r);

		// 结果是浮点型
		int i = 10, j = 3;
		System.out.println(i / (float) j);

		// 字符串+运算

		String name = "tom";
		String email = "tom@gmail.com";
		int age = 20;
		String msg = name + "," + email + "," + age;
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		testTerm();
		System.out.println("=======================");
		testAPP();
		System.out.println("=======================");
		testAssign();
		System.out.println("=======================");
		testLogic();
		System.out.println("=======================");
		testRelation();
	}
}
