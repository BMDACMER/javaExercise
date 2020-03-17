package java01;

/**
 * 对应课本P2例子
 * 1.1 不可变类
 * “Hello” 是String类型，String是不可变量，存储在常量池里（如果是new出来的则存储在堆中），
 * str += "world" 并没有创建新的对象，只是指向了Helloworld字符串，原来的Hello依旧在常量池里。
 *
 */
public class Code_000_Test {
    public static void main(String[] args) {
        String str = "Hello";
        str += "world";
        System.out.println(str);

//        byte b1=1,b2=2,b3,b6;
//        final byte b4=4,b5=6;
//        b6=b4+b5;   // 10
//        b3=(byte) (b1+b2);  // 3
//        System.out.println(b3+b6);  // 13
    }
}

