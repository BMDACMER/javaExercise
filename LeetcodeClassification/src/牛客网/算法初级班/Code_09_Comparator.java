package 牛客网.算法初级班;

import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/30 16:35
 * 比较器
 */
public class Code_09_Comparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student (String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }
}
