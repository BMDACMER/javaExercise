package com.imooc.dao;

import com.imooc.domain.Student;
import com.imooc.util.JDBCUtil;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 16:53
 */
public class StudentDAOImplTest {

    @Test
    public void testQuery() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
            + ", name:" + student.getName()
            + ", age:" + student.getAge());
        }
    }

    @Test
    public void testSave() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(30);

        studentDAO.save(student);
    }
}
