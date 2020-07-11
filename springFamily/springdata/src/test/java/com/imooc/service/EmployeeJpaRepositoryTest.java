package com.imooc.service;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeJpaRepository;
import com.imooc.repository.EmployeePagingAndSortingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 22:41
 */
public class EmployeeJpaRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind() {

        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println("employee:" + employee);
        System.out.println("employee(10):" + employeeJpaRepository.exists(10));
        System.out.println("employee(102):" + employeeJpaRepository.exists(102));


//        // page: index是0开始，不是从1开始的
//        PageRequest pageable = new PageRequest(0,5);
//
//        Page<Employee> page = employeeJpaRepository.findAll(pageable);
//        System.out.println("查询的总页数" + page.getTotalPages());
//        System.out.println("查询的总记录数" + page.getTotalElements());
//        System.out.println("查询的当前第几页" + page.getNumber() + 1);
//        System.out.println("查询的当前页面的集合" + page.getContent());
//        System.out.println("查询的当前页面的记录数" + page.getNumberOfElements());
    }


}
