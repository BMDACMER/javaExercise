package ui;


import factory.BeanFactory;
import service.IAccountService;

/**
 * ģ��һ�����ֲ㣬���ڵ���ҵ���
 */
public class Client {

    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
