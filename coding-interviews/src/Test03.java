import org.omg.CORBA.ORB;

import javax.print.attribute.standard.OrientationRequested;

/**
 * ��Ŀ�����һ���࣬����ֻ�����ɸ����һ��ʵ��
 *
 * ����ģʽ
 */
public class Test03 {

    public static void main(String[] args) {
        // ����ʽһ
//        System.out.println(Bank.getInstance() == Bank.getInstance());
////        System.out.println(Bank.getInstance());
//        // ����ʽ2
//        System.out.println(Order.getInstance() == Order.getInstance());
//
//        // ����ʽ1���߲���������û������ĺã�
//        System.out.println(Bank2.getInstance() == Bank2.getInstance());
//        System.out.println("===========================================");
//        // ����ʽ2 (�߲���ʵ�֣��Ƽ���
//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{
//               Order2.getInstance();  // ÿ���̵߳��õĶ�һ��
//            },String.valueOf(i+1)).start();
//        }

        // ����ʽ3   �����̲߳���ȫ   ����false����
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Order3.getInstance() == Order3.getInstance());
//                System.out.println(Order3.getInstance());
            },String.valueOf(i+1)).start();

            new Thread(()->{
                System.out.println(Order3.getInstance() == Order3.getInstance());
//                System.out.println(Order3.getInstance());
            },String.valueOf(i+1)).start();

            new Thread(()->{
                System.out.println(Order3.getInstance() == Order3.getInstance());
//                System.out.println(Order3.getInstance());
            },String.valueOf(i+1)).start();
        }
    }
}

// ����ʽ1
class Bank{

    //1.˽����Ĺ�����
    private Bank(){

    }

    //2.�ڲ�������Ķ���
    //4.Ҫ��˶���Ҳ��������Ϊ��̬��
    private static Bank instance = new Bank();

    //3.�ṩ�����ľ�̬�ķ�����������Ķ���
    public static Bank getInstance(){
        return instance;
    }
}

// ����ʽ2
class Order{

    //1.˽����Ĺ�����
    private Order(){

    }

    //2.������ǰ�����û��ʼ��
    //4.�˶���Ҳ��������Ϊstatic��
    private static Order instance = null;

    static{
        instance = new Order();
    }

    //3.����public��static�ķ��ص�ǰ�����ķ���
    public static Order getInstance(){
        return instance;
    }
}

// ����ʽ1���̰߳�ȫ�ģ�
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
// ����ʽ2   �̰߳�ȫ���߲�����
class Order2{
    private Order2(){
        System.out.println("��" + Thread.currentThread().getName() + "�̵߳Ĺ��췽��");
    }

    private static volatile Order2 instance = null;   // ����volatile��֤�˿ɼ���
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

// ����ʽ �̲߳���ȫ��
class Order3{
    private Order3(){
//        System.out.println("��������ʽ���̲߳���ȫŶ");
    }

    private static Order3 instance = null;

    public static Order3 getInstance(){
        if (instance == null){
            instance = new Order3();
        }
        return instance;
    }

}