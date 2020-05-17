package com.gh.test;

public class Employee {
    private Integer jobNumber;  // 工号
    private String name;   // 姓名
    private Integer age;   // 年龄

    public Integer getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Integer jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 构造方法 实现对所有成员变量的初始化
    public Employee(Integer jobNumber, String name, Integer age) {
        this.jobNumber = jobNumber;
        this.name = name;
        this.age = age;
    }

    // 打印出员工信息

    @Override
    public String toString() {
        return "Employee{" +
                "jobNumber=" + jobNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
