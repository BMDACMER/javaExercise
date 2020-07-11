package com.imooc.service;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeCrudRepository;
import com.imooc.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 22:41
 */
public class EmployeeCrudRepositoryTest {
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
    public void testSave() {
        List<Employee> employees = new ArrayList<>();

        Employee employee = null;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test" + i);
            employee.setAge(100 - i);
            employees.add(employee);
        }
        employeeService.save(employees);
    }
}
