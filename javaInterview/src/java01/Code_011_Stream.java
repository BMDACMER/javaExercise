package java01;

import sun.rmi.server.InactiveGroupException;

import java.util.*;
import java.util.stream.Collectors;

public class Code_011_Stream {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<>();
        l.add(new Student("Wang",10));
        l.add(new Student("Li",13));
        l.add(new Student("Zhang",10));
        l.add(new Student("Zhao",15));
        System.out.println("�ҳ�����Ϊ10 �ĵ�һ��ѧ����");
        Optional<Student> s = l.stream().filter(stu -> stu.getAge().equals(10)).findFirst();
        if (s.isPresent()){
            System.out.println(s.get().getName() + "," + s.get().getAge());
        }
        System.out.println("�ҳ�����Ϊ10������ѧ����");
        List<Student> searchResult = l.stream().filter(stu -> stu.getAge().equals(10)).collect(Collectors.toList());
        for (Student stu:searchResult){
            System.out.println(stu.getName() + "," + stu.getAge());
        }
        System.out.println("��ѧ�����������");
        Map<Integer,List<Student>> map = l.stream().collect(Collectors.groupingBy(Student::getAge));
        Iterator<Map.Entry<Integer,List<Student>>> iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer,List<Student>> entry = (Map.Entry<Integer, List<Student>>) iter.next();
            int age = entry.getKey();
            System.out.println("age:" + age + ":");
            List<Student> group = entry.getValue();
            for (Student stu:group){
                System.out.println(stu.getName() + " ");
            }
            System.out.println();
        }
    }
}

class Student{
    private String name;
    private Integer age;  // ��������� ��װ�� ����

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
