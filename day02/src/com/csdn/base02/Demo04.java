package com.csdn.base02;

public class Demo04 {

	// ��Ԫ���� e1 ? e2 : e3
	static void testTerm() {
		// ����������
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

	// �����Լ�
	// ������++������������ֵ��1����ǰ׺ʽ����++i���ͺ�׺ʽ����i++����ǰ׺ʽ���ȼ�1��ʹ�ã���׺ʽ����ʹ���ټ�1��
	// �Լ���--������������ֵ��1����ǰ׺ʽ����--i���ͺ�׺ʽ����i--����ǰ׺ʽ���ȼ�1��ʹ�ã���׺ʽ����ʹ���ټ�1��
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

	// ��ֵ���� =
	static void testAssign() {
		// 1. �򵥸�ֵ
		int x = 1; // ����
		int y = x; // ����
		int z = x + y; // ���ʽ
		int s = Math.max(1, 2); // ��������ֵ�ȵ�

		// 2. ���ϸ�ֵ ��������
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

	// �߼����� & | ! && ||
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

		// && ���ǰ��ı��ʽ����ȷ����� ����ı��ʽ�����ټ���

		int a = 1, b = 2, c = 3;

		if (a > b && c++ > 10) {
			System.out.println("run");
		}
		System.out.println(c);

		// ��·��
		if (a < b || c++ > 10) {
			System.out.println("run...");
		}
		System.out.println(c);
	}

	// ��ϵ���� > >= < <= == !=
	static void testRelation() {
		// �������͵ıȽ�
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
	
	// �������� + - * / %
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
		result = a / b; // ���ȡ��
		System.out.println("a/b=" + result);
		result = a % b;
		System.out.println("a%b=" + result);
		// ��0��
		int x = 0, y = 20;
		// int r = y / x;
		// System.out.println(r);

		// ����Ǹ�����
		int i = 10, j = 3;
		System.out.println(i / (float) j);

		// �ַ���+����

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
