package com.csdn.base02.extend;

/**
 * 继承可以继承除private私有属性外的一些属性和方法 Object 是Java中的顶级父类
 * 
 * @author guohao
 *
 */
public class Demo11 {

	public static void main(String[] args) {
		Dog dog = new Dog();
		System.out.println(dog.age);
		System.out.println(dog.color);
		System.out.println(dog.name);
//		System.out.println(dog.privateStr);   // 访问不了  因为是私有变量
		dog.eat();
		dog.m2();
		dog.m3();
//		dog.m1();  // 访问不了 ，因为是私有方法
	}
}

class Animal{
	private String privateStr = "privateStr";
	String name = "huahua";
	protected int age = 4;
	public String color = "黑色";
	
	public void eat() {
		System.out.println("eat...");
	}
	
	private void m1() {
		System.out.println("m1");
	}
	
	protected void m2() {
		System.out.println("m2");
	}
	
	void m3() {
		System.out.println("m3");
	}
}

//方法覆盖 是在继承关系里面 子类覆盖父类同名方法
//super 父类的引用
//this 当前对象
class Dog extends Animal{
	@Override
	public void eat() {
		super.eat();
		
		System.out.println("Dog eat...");
	}
}



// 方法重载  方法名相同 参数的个数或者类型不同  一个类里面
class Person {

	String name;
	int age;

	// 构造方法重载
	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void eat() {
		System.out.println("eat...");
	}

	public void eat(String food) {
		System.out.println("eat " + food);
	}
}
