package java03;

import java.util.Properties;

// 买房接口抽象主题
interface IBuyHouse{
    public void buy();
}

// 具体主题
class Customer implements IBuyHouse{

    @Override
    public void buy() {
        System.out.println("购房成功");
    }
}

// 代理
class Proxy implements IBuyHouse{

    private IBuyHouse subject;

    public Proxy(IBuyHouse subject) {
        this.subject = subject;
    }
    // 根据具体需求实现审核功能
    private boolean checkCredit(){
        return true;
    }

    @Override
    public void buy() {
        System.out.println("中介处理其他手续后，与房主或开发商完成交易");
        if (checkCredit()) {
            subject.buy();   // 真实的购房
        }else {
            System.out.println("不能贷款，无法完成交易");
        }
    }
}


public class Code_02_JVM_Reflect02 {
    public static void main(String[] args) {
        IBuyHouse subject = new Customer();
        Proxy proxy = new Proxy(subject);   // 将真实的购房对象  放进代理类中
        proxy.buy();
    }
}
