package java03;

import java.util.Properties;

// �򷿽ӿڳ�������
interface IBuyHouse{
    public void buy();
}

// ��������
class Customer implements IBuyHouse{

    @Override
    public void buy() {
        System.out.println("�����ɹ�");
    }
}

// ����
class Proxy implements IBuyHouse{

    private IBuyHouse subject;

    public Proxy(IBuyHouse subject) {
        this.subject = subject;
    }
    // ���ݾ�������ʵ����˹���
    private boolean checkCredit(){
        return true;
    }

    @Override
    public void buy() {
        System.out.println("�н鴦�������������뷿���򿪷�����ɽ���");
        if (checkCredit()) {
            subject.buy();   // ��ʵ�Ĺ���
        }else {
            System.out.println("���ܴ���޷���ɽ���");
        }
    }
}


public class Code_02_JVM_Reflect02 {
    public static void main(String[] args) {
        IBuyHouse subject = new Customer();
        Proxy proxy = new Proxy(subject);   // ����ʵ�Ĺ�������  �Ž���������
        proxy.buy();
    }
}
