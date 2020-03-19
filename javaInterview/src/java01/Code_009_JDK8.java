package java01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

/**
 * Java8之前，通过匿名函数的方法来代替Lambda表达式
 *
 */
public class Code_009_JDK8 {

    public static void main(String[] args) {
        Person[] person = {
                new Person(25,"Jame"),
                new Person(23,"Jack")
        };
        // 自定义类排序方法，通过年龄进行排序
        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        // 采用Lambda表达式后
        // 方法一
        Arrays.sort(person, (Person a,Person b) -> Integer.compare(a.getAge(),b.getAge()));
        //  方法二
        Arrays.sort(person, (a, b) -> Integer.compare(a.getAge(),b.getAge()));
        //方法三
        Arrays.sort(person,Comparator.comparing(Person::getAge));
        for (Person p : person){
            System.out.println(p);
        }

    }


    @Test
    public void test(){
        // 引用构造方法
        Person p1 = Person.getInstance(Person::new);
        p1.setAge(19);
        System.out.println("测试引用构造方法：" + p1.getAge());
        Person[] person = {
                new Person(25,"guohao"),
                new Person(26,"wyh")
        };

        // 引用特定类的任意对象方法
        Arrays.sort(person, Comparator.comparing(Person::getAge));
        System.out.println("测试引用特定类的任意对象方法：");
        for (Person p: person){
            System.out.println(p);
        }

        // 引用类静态方法
        Arrays.sort(person, Person::compareByAge);
        System.out.println("测试引用类静态方法：");
        for (Person p:person){
            System.out.println(p);
        }

        // 引用某个对象的方法
        Arrays.sort(person, new CompareProvider()::compareByAge);
        System.out.println("测试引用某个对象的方法");
        for (Person p:person){
            System.out.println(p);
        }
    }
}

class Person{
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static Person getInstance(final Supplier<Person> supplier){
        return supplier.get();
    }

    public static int compareByAge(Person a, Person b){
        return Integer.compare(a.getAge(),b.getAge());
    }


    @Override
    public String toString() {
        return name + ":" + age;
    }
}


class CompareProvider{
    public int compareByAge(Person a, Person b){
        return Integer.compare(a.getAge(),b.getAge());
    }
}