package java03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// �����ɫ
interface Subject{
    public abstract void request();
}

// ��ʵ��ɫ
class RealSubject implements Subject{

    public RealSubject() {
    }

    @Override
    public void request() {
        System.out.println("������ʵ��ɫ�ķ���");
    }
}

// ��̬����
class DynamicSubject implements InvocationHandler{
    private Object subject;

    public DynamicSubject() {
    }

    public DynamicSubject(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("׼�����÷�����" + method);
        method.invoke(subject,args);
        System.out.println("���ý�����" + method);
        return null;
    }
}
public class Code_02_JVM_Reflect03 {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler dynSubject = new DynamicSubject(realSubject);
        Class<?> c = realSubject.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(c.getClassLoader(),c.getInterfaces(),dynSubject);
        subject.request();
    }
}
