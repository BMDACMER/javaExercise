package com.imooc.domain;


import javax.persistence.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 19:12
 */
// 雇员： 先开发实体类 ---> 自动生成数据表

@Entity
@Table(name = "test_employee")
public class Employee {

    private Integer id;
    private String name;
    private Integer age;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // 返回表长度不超过20

    @Column(length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
