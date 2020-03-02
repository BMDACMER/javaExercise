package com.csdn.base02.polymorphism;

/*
 * java 多态   一个方法有多种状态
 * 向上类型转换
 * 方法的动态绑定
 */
public class Demo12 {

	public static void main(String[] args) {
		Person person = new Person();
		Animal a = new Cat();
		Animal b = new Dog();
		Animal bird = new Bird();
		person.care(a);
		person.care(b);
		person.care(bird);
	}
}


class Person{
	public void care(Animal a) {
		a.eat();
		a.sleep();
	}
}


interface Animal{
	public void eat();
	public void sleep();
}

class Cat implements Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("cat is eating a fish");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("cat is sleeping");
	}
	
}

class Bird implements Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Bird is eating");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Bird is sleeping");
	}
	
}

class Dog implements Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("dog eat...");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("dog sleep...");
	}
	
}


