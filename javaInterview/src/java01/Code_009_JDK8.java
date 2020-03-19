package java01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

/**
 * Java8֮ǰ��ͨ�����������ķ���������Lambda���ʽ
 *
 */
public class Code_009_JDK8 {

    public static void main(String[] args) {
        Person[] person = {
                new Person(25,"Jame"),
                new Person(23,"Jack")
        };
        // �Զ��������򷽷���ͨ�������������
        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        // ����Lambda���ʽ��
        // ����һ
        Arrays.sort(person, (Person a,Person b) -> Integer.compare(a.getAge(),b.getAge()));
        //  ������
        Arrays.sort(person, (a, b) -> Integer.compare(a.getAge(),b.getAge()));
        //������
        Arrays.sort(person,Comparator.comparing(Person::getAge));
        for (Person p : person){
            System.out.println(p);
        }

    }


    @Test
    public void test(){
        // ���ù��췽��
        Person p1 = Person.getInstance(Person::new);
        p1.setAge(19);
        System.out.println("�������ù��췽����" + p1.getAge());
        Person[] person = {
                new Person(25,"guohao"),
                new Person(26,"wyh")
        };

        // �����ض����������󷽷�
        Arrays.sort(person, Comparator.comparing(Person::getAge));
        System.out.println("���������ض����������󷽷���");
        for (Person p: person){
            System.out.println(p);
        }

        // �����ྲ̬����
        Arrays.sort(person, Person::compareByAge);
        System.out.println("���������ྲ̬������");
        for (Person p:person){
            System.out.println(p);
        }

        // ����ĳ������ķ���
        Arrays.sort(person, new CompareProvider()::compareByAge);
        System.out.println("��������ĳ������ķ���");
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