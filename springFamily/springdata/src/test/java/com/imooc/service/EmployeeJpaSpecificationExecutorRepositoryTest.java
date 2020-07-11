package com.imooc.service;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeJpaRepository;
import com.imooc.repository.EmployeeJpaSpecificationRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 22:41
 */
public class EmployeeJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationRepository employeeJpaSpecificationRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationRepository = ctx.getBean(EmployeeJpaSpecificationRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0,5,sort);

        /**
         * root:就是我们要查询的类型(Employee)
         * criteriaQuery:添加查询条件
         * criteriaBuilder:构建Predicate
         *
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Path path = root.get("age");

                return  criteriaBuilder.gt(path, 50);
            }
        };

        Page<Employee> page = employeeJpaSpecificationRepository.findAll(specification,pageable);
        System.out.println("查询的总页数" + page.getTotalPages());
        System.out.println("查询的总记录数" + page.getTotalElements());
        System.out.println("查询的当前第几页" + page.getNumber() + 1);
        System.out.println("查询的当前页面的集合" + page.getContent());
        System.out.println("查询的当前页面的记录数" + page.getNumberOfElements());

    }


}
