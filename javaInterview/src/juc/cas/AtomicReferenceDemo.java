package juc.cas;


import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User user1 = new User("张三", 22);
        User user2 = new User("李四", 23);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        // 对user1 操作  原来的为user1  被改为user2   最后一条语句  期望user1  但是现在已经是user2
        atomicReference.set(user1);
        System.out.println(atomicReference.compareAndSet(user1, user2) + "\t" + atomicReference.get().toString());//true	juc.cas.User@14ae5a5
        System.out.println(atomicReference.compareAndSet(user1, user2) + "\t" + atomicReference.get().toString());//false	juc.cas.User@14ae5a5
    }
}


class User {
    private String userName;
    private int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
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