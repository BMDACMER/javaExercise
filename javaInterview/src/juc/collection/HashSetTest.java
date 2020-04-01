package juc.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 线程不安全
 */
public class HashSetTest {
    // 故障现象
    public static void notSafe(){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            },String.valueOf(i+1)).start();
        }
    }

//    @Test
    public static void testSafe1(){
        Set<String> list = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },"Thread " + i).start();
        }
    }

    public static void safe2() {
        Set<String> list = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }

    public static void main(String[] args) {
//        safe2();
        testSafe1();
    }
}
