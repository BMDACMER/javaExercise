package java01;

import org.junit.Test;

/**
 * �̳е���ҪĿ�ľ���Ϊ�����ø�������Ի��߷���
 */

// ͨ���ӿ���ʵ��
interface CanFly{
    public abstract void fly();
}

interface CanRun{
    void run();
}

class Animal{
    public void getCatagory(){
        System.out.println("I'm animal");
    }
}

class Duck extends Animal implements CanFly, CanRun{

    @Override
    public void fly() {
        System.out.println("I can fly!");
    }

    @Override
    public void run() {
        System.out.println("I can run~");
    }
}


public class Code_005_Extends {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.getCatagory();
        duck.fly();
        duck.run();
    }

    @Test
    public void testInnerClass(){
        Computer computer = new Computer();
        computer.m();
        computer.c();
    }

}

// ͨ���ڲ���ʵ��
class Memory{
    public void m(){
        System.out.println("Memory");
    }
}

class CPU{
    public void c(){
        System.out.println("CPU");
    }
}

class Computer{
    class Memory1 extends Memory{}
    class CPU1 extends CPU{}
    public void m(){
        new Memory1().m();
    }
    public void c(){
        new CPU1().c();
    }
}

