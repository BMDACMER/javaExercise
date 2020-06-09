package ui;


import factory.BeanFactory;
import service.IAccountService;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
//        for(int i=0;i<5;i++) {
//            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
//            System.out.println(as);
//            as.saveAccount();
//
//        }

        HashMap<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put(null,3);
        map.put(null,3);
        map.put("1",3);

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
