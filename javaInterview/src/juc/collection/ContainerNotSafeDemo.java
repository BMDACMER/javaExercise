package juc.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * �����಻��ȫ����
 * ArrayList
 */
public class ContainerNotSafeDemo {
    /**
     * ��������
     * java.util.ConcurrentModificationException
     */
    public static void notSafe(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                // UUID(Universally Unique Identifier)ȫ��Ψһ��ʶ��,��ָ��һ̨���������ɵ����֣�
                // ����֤����ͬһʱ���е����л�������Ψһ�ģ�����һ��ʮ��λ���������,���ֳ�������ʽ
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    // �������1�� ʹ��Vector
    public static void vectorTest(){
        List<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }


    // �������2��ʹ��Collections������
    public static void collectionsTest(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    //�������3  CopyOnWriteArrayList
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
//        notSafe();  // �����̲߳���ȫ
//        vectorTest();  // ʹ��vector���
//        collectionsTest();
        copyOnWriteArrayListTest();
    }
}
