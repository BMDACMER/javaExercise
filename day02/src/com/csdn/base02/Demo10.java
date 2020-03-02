package com.csdn.base02;
/**
 * 接口的作用是为了更好的实现程序的抽象过程
 * @author guohao
 *
 */
public class Demo10 {

	public static void main(String[] args) {
//		Animal a = new Animal();
		Dog dog = new Dog();
		dog.eat();
		dog.sleep();
		dog.play();
		System.out.println("===================");
		
		Cat cat = new Cat();
		cat.eat();
		cat.sleep();
		cat.play();
		System.out.println("********************");
		
		FlyFish ff = new FlyFish();
		ff.swim();
		ff.fly();
		System.out.println("*********=============*******");
		
		Mobile m = new Mobile();
		m.play();
		m.playVideo();
		
	}
}

class FlyFish implements Bird, Fish{

	@Override
	public void swim() {
		System.out.println("swim...");
		
	}

	@Override
	public void fly() {
		System.out.println("fly...");
		
	}
	
}

interface Bird{
	public void fly();
}

interface Fish{
	public void swim();
}

interface Player{
	public void play();
}

interface VideoPlayer extends Player{
	public void playVideo();
}

class Mobile implements VideoPlayer{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("mobile is playing...");
	}

	@Override
	public void playVideo() {
		// TODO Auto-generated method stub
		System.out.println("mobile is playVideo...");
	}
	
}

interface Animal{
	public void eat();
	public void sleep();
	public void play();
}

class Cat implements Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("cat eat...");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("cat sleep...");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("cat play...");
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

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("dog play...");
	}
	
}


