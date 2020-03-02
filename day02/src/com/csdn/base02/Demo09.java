package com.csdn.base02;

public class Demo09 {

	public static void main(String[] args) {
		// 有类产生对象的过程叫做实例化
		// 对象Object == 实例instance
		// 有一个类可以创建多个实例
		Person tom = new Person();
		tom.name = "tom";
		tom.age = 26;
		tom.eat();
		tom.sleep();
		
		System.out.println(tom.name + "," + tom.age);
		
		System.out.println("--------------");
		
		Person kite = new Person();
		kite.name = "kite";
		kite.age = 21;
		kite.eat();
		kite.sleep();
//		System.out.println(kite.pid);
		
		System.out.println(kite.name+","+kite.age);
		
		System.out.println("----------");
		
		System.out.println(Person.pid);
		Person.m1();
		
		Person rose = new Person("rose", 18);
		System.out.println(rose.name+","+rose.age);		
		
	}
}


//类和对象
//构造方法
//类变量和实例变量
//类方法和实例方法
//this关键字

//类变量和类方法 也叫静态变量和静态方法
//特点 不需要实例化直接可以通过类名称来方法

//this 是一个指代对象 当前对象是谁 this就值得是谁
class Person{
	
	// 实例变量
		String name;
		int age;
		// 实例方法
		// 构造方法
		public Person() {
			System.out.println("实例化。。。");
		}
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		static int pid = 1;
		static void m1() {
			System.out.println("m1...");
		}
		public void eat() {
			System.out.println("eat...");
		}
		public void sleep() {
			System.out.println("sleep...");
		}
}
