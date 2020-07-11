package com.imooc.service;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 21:46
 */
public class EmployeeServiceTest {
    private ApplicationContext ctx = null;
    private EmployeeService employeeService = null;


    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testUpdate() {
        employeeService.update(1, 55);
    }


}
