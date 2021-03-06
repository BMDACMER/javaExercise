import org.omg.CORBA.ORB;

import javax.print.attribute.standard.OrientationRequested;

// 饿汉式1
class Bank{

    //1.私化类的构造器
    private Bank(){

    }

    //2.内部创建类的对象
    //4.要求此对象也必须声明为静态的
    private static Bank instance = new Bank();

    //3.提供公共的静态的方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}

// 饿汉式2
class Order{

    //1.私化类的构造器
    private Order(){

    }

    //2.声明当前类对象，没初始化
    //4.此对象也必须声明为static的
    private static Order instance = null;

    static{
        instance = new Order();
    }

    //3.声明public、static的返回当前类对象的方法
    public static Order getInstance(){
        return instance;
    }
}

// 懒汉式1（线程安全的）
class Bank2{
    private Bank2(){

    }

    private static Bank2 instance = null;
    public static Bank2 getInstance(){
        if (instance == null){
            synchronized (Bank2.class){
                if (instance == null){
                    instance = new Bank2();
                }
            }
        }
        return instance;
    }
}
// 懒汉式2   线程安全（高并发）
class Order2{
    private Order2(){
        System.out.println("第" + Thread.currentThread().getName() + "线程的构造方法");
    }

    private static volatile Order2 instance = null;   // 加了volatile保证了可见性
    public static Order2 getInstance(){
        if (instance == null){
            synchronized (Order2.class){
                if (instance == null){
                    instance = new Order2();
                }
            }
        }
        return instance;
    }
}

// 懒汉式 线程不安全的
class Order3{
    private Order3(){
//        System.out.println("我是懒汉式，线程不安全哦");
    }

    private static Order3 instance = null;

    public static Order3 getInstance(){
        if (instance == null){
            instance = new Order3();
        }
        return instance;
    }

}