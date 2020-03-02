package com.csdn.base02.extend;

/**
 * �̳п��Լ̳г�private˽���������һЩ���Ժͷ��� Object ��Java�еĶ�������
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
//		System.out.println(dog.privateStr);   // ���ʲ���  ��Ϊ��˽�б���
		dog.eat();
		dog.m2();
		dog.m3();
//		dog.m1();  // ���ʲ��� ����Ϊ��˽�з���
	}
}

class Animal{
	private String privateStr = "privateStr";
	String name = "huahua";
	protected int age = 4;
	public String color = "��ɫ";
	
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

//�������� ���ڼ̳й�ϵ���� ���า�Ǹ���ͬ������
//super ���������
//this ��ǰ����
class Dog extends Animal{
	@Override
	public void eat() {
		super.eat();
		
		System.out.println("Dog eat...");
	}
}



// ��������  ��������ͬ �����ĸ����������Ͳ�ͬ  һ��������
class Person {

	String name;
	int age;

	// ���췽������
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
