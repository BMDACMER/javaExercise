package javaCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("��������");
        coll.add("�²�����");
        coll.add("������");
        //����
        //ʹ�õ����� ����   ÿ�����϶������Լ��ĵ�����
        Iterator it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
