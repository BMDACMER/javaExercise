package com.csdn.base02;

public class Demo02 {
	public static void main(String[] args) {
		Boy boy = new Boy();
		boy.getMsg();
		boy.eat();
		boy.sleep();
		
		System.out.println("=====================");
		Boy tom = new Boy();
		tom.name = "tom";
		tom.age = 17;
		
		tom.getMsg();
		tom.eat();
		tom.sleep();
	}

}

class Boy{
	String name = "kite";
	int age = 18;
	
	public void getMsg() {
		System.out.println(name + "," + age);
	}
	public void eat() {
		System.out.println("³Ô·¹");
	}
	public void sleep() {
		System.out.println("Ë¯¾õ");
	}
}
