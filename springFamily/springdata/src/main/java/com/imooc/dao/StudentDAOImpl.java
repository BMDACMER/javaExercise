package com.imooc.dao;

import com.imooc.domain.Student;
import com.imooc.util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 16:35
 */
public class StudentDAOImpl implements StudentDAO{
    @Override
    public List<Student> query() {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select id, name, age from student";

        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into student(name, age) values(?,?)";

        try {
            connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1, student.getName());
            preparedStatement1.setInt(2,student.getAge());
            preparedStatement1.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
    }
}
