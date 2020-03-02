package com.csdn.base02;

public class Demo05 {

	static void testStr1() {
		String name = "tom";
		System.out.println(name);
		String name2 = new String("kite");
		System.out.print(name2);
		System.out.println(name.length());
		System.out.println(name2.length());
	}
	
	static void testStr2() {
		String s1 = "hello ";
		String s2 = "world!";
		System.out.println(s1+s2);
		System.out.println(s1.concat(s2));
	}

	static void testStr3() {
		String name = "tom";
		int age = 20;
		double salary = 3000.5;
		String msg = String.format("姓名：%s, 年龄：%d, 薪水:%.2f", name, age, salary);
		System.out.println(msg);
	}
	
	static void testStr4() {
//		charAt
//		length
//		substring
//		trim  // 去掉字符串两端空格
//		indexOf  
		String s = "hello World!";
//		System.out.println(s.charAt(0));
//		for (int i = 0; i < s.length(); i++) {
//			System.out.print(s.charAt(i) + " ");
//		}
//		System.out.println(s.substring(3, 6));
//		String s2 = "   hello world   ";
//		System.out.println(s2.length());
//		System.out.println(s2.trim().length());
//		System.out.println(s2.trim());
		
		System.out.println(s.indexOf('l'));  // 2
		System.out.println(s.indexOf("World!")); // 6
		
	}
	
	public static void main(String[] args) {
		testStr1();
		System.out.println("====================");
		testStr2();
		System.out.println("====================");
		testStr3();
		System.out.println("====================");
		testStr4();
	}
}
