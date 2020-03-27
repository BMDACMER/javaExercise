package java03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 抽象角色
interface Subject{
    public abstract void request();
}

// 真实角色
class RealSubject implements Subject{

    public RealSubject() {
    }

    @Override
    public void request() {
        System.out.println("调用真实角色的方法");
    }
}

// 动态代理
class DynamicSubject implements InvocationHandler{
    private Object subject;

    public DynamicSubject() {
    }

    public DynamicSubject(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备调用方法：" + method);
        method.invoke(subject,args);
        System.out.println("调用结束：" + method);
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
