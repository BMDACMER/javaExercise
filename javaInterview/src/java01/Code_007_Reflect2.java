package java01;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * �������
 */
public class Code_007_Reflect2 {

    protected Code_007_Reflect2(){
        System.out.println("Protected constructor");
    }

    public Code_007_Reflect2(String name){
        System.out.println("Public constructor");
    }

    public void f(){
        System.out.println("f()");
    }

    public void g(int i){
        System.out.println("g(): " + i);
    }

    // �ڲ���
    class Inner{}


    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java01.Code_007_Reflect2");

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Code_007_Reflect2��Ĺ��캯��");
        for (Constructor<?>c : constructors){
            System.out.println(c); // protected java01.Code_007_Reflect2()  public java01.Code_007_Reflect2(java.lang.String)
        }

        Method[] methods = clazz.getMethods();
        System.out.println("Code_007_Reflect2ȫ��public����");
        for (Method md: methods){
            System.out.println(md);
        }

        Class<?>[] inner = clazz.getDeclaredClasses();
        System.out.println("Code_007_Reflect2����ڲ���Ϊ��");
        for (Class<?> c : inner){
            System.out.println(c);  // class java01.Code_007_Reflect2$Inner
        }
    }

}