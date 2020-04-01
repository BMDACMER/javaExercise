package juc.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全问题
 * ArrayList
 */
public class ContainerNotSafeDemo {
    /**
     * 故障现象
     * java.util.ConcurrentModificationException
     */
    public static void notSafe(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                // UUID(Universally Unique Identifier)全局唯一标识符,是指在一台机器上生成的数字，
                // 它保证对在同一时空中的所有机器都是唯一的，是由一个十六位的数字组成,表现出来的形式
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    // 解决方案1： 使用Vector
    public static void vectorTest(){
        List<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }


    // 解决方案2：使用Collections辅助类
    public static void collectionsTest(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    //解决方案3  CopyOnWriteArrayList
    public static void copyOnWriteArrayListTest(){
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }


    public static void main(String[] args) {
//        notSafe();  // 测试线程不安全
//        vectorTest();  // 使用vector解决
//        collectionsTest();
        copyOnWriteArrayListTest();
    }
}
