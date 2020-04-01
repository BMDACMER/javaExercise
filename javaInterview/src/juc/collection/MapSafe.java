package juc.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapSafe {
    // ��������
    public static void notSafe(){
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            }, "Thread " + i).start();
        }
    }

    // ����취1   Collections.synchronizedMap
    public static void collectionsSafe(){
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            }, "Thread " + i).start();
        }
    }

    // ����취2   copyOnWriteMap
    public static void ConcurrentHashMapSafe(){
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            }, "Thread " + i).start();
        }
    }

    public static void main(String[] args) {
//        notSafe();
//        collectionsSafe();
        ConcurrentHashMapSafe();
    }
}
