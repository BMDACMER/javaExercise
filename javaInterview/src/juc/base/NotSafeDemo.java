package juc.base;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  ��Ŀ�������˵���������ǲ���ȫ��
 *  1  ��������
 *      java.util.ConcurrentModificationException
 *  2  ����ԭ��
 *  3  �������
 *      3.1 Vector
 *      3.2 Collections.synchronizedList(new ArrayList<>())
 *      3.3 List�߳�CopyOnWriteArrayList
 *          set�߳�CopyOnwriteHashSet
 *          map�߳�ConcurrentHashMap
 *  4  �Ż����飨ͬ���Ĵ��󣬲����ֵڶ��Σ�
 *
 */
public class NotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    // ����HashSet
    @Test
    public void testHashSet() {
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    // ����HashMap
    @Test
    public void testHashMap() {
        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}

/**
 * дʱ����
 CopyOnWrite������дʱ���Ƶ���������һ���������Ԫ�ص�ʱ�򣬲�ֱ������ǰ����Object[]��ӣ�
 �����Ƚ���ǰ����Object[]����Copy�����Ƴ�һ���µ�����Object[] newElements��Ȼ�����µ�����Object[] newElements�����Ԫ�ء�
 ���Ԫ�غ��ٽ�ԭ����������ָ���µ�����setArray(newElements)��
 �������ĺô��ǿ��Զ�CopyOnWrite�������в����Ķ���������Ҫ��������Ϊ��ǰ������������κ�Ԫ�ء�
 ����CopyOnWrite����Ҳ��һ�ֶ�д�����˼�룬����д��ͬ��������

 *
 *
 *
 *

 public boolean add(E e) {
 final ReentrantLock lock = this.lock;
 lock.lock();
 try {
 Object[] elements = getArray();
 int len = elements.length;
 Object[] newElements = Arrays.copyOf(elements, len + 1);
 newElements[len] = e;
 setArray(newElements);
 return true;
 } finally {
 lock.unlock();
 }
 }
 */