package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import factory.BeanFactory;
import service.IAccountService;

public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();
//    private IAccountDao accountDao = (IAccountDao) new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    int i = 1;

    @Override
    public void saveAccount() {

        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
