package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 17:40
 */
public class StudentDAOSpringJdbcImplTest {
    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void tearQuery() {
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
            + " , name:" + student.getName() + " , age:" + student.getAge());
        }
    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("test-spring-jdbc");
        student.setAge(40);

        studentDAO.save(student);
    }

}
