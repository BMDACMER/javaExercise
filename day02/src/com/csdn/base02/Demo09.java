package com.csdn.base02;

public class Demo09 {

	public static void main(String[] args) {
		// �����������Ĺ��̽���ʵ����
		// ����Object == ʵ��instance
		// ��һ������Դ������ʵ��
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


//��Ͷ���
//���췽��
//�������ʵ������
//�෽����ʵ������
//this�ؼ���

//��������෽�� Ҳ�о�̬�����;�̬����
//�ص� ����Ҫʵ����ֱ�ӿ���ͨ��������������

//this ��һ��ָ������ ��ǰ������˭ this��ֵ����˭
class Person{
	
	// ʵ������
		String name;
		int age;
		// ʵ������
		// ���췽��
		public Person() {
			System.out.println("ʵ����������");
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
