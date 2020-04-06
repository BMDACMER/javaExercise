package juc.base;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StringDemo {
    public static void main(String[] args) {
        //R apply(T t);函数型接口，一个参数，一个返回值
        Function<String, Integer> function = t -> {return t.length();};
        System.out.println(function.apply("abcd"));

        // boolean test(T t);断定型接口，一个参数，返回boolean
        Predicate<String> predicate = t->{return t.startsWith("a");};
        System.out.println(predicate.test("a"));

        //  void accept(T t);消费型接口，一个参数，没有返回值
        Consumer<String> consumer = t -> {
            System.out.println(t);
        };
        consumer.accept("javaXXXX");

        //T get(); 供给型接口，无参数，有返回值
        Supplier<String> supplier = () -> {return UUID.randomUUID().toString();};
        System.out.println(supplier.get());
        System.out.println("\n\n***************************************\n");

    }

    /*
     * 题目：请按照给出数据，找出同时满足
     *      偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
     *      最后只输出一个用户名字
     */
    @Test
    public void test() {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4);

        list.stream().filter(p -> {
            return p.getId() % 2 == 0;
        }).filter(p -> {
            return p.getAge() > 24;
        }).map(f -> {
            return f.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);

    }
}

class User {
    private Integer id;
    private String userName;
    private int age;

    public User(Integer id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

