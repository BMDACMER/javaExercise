package javaCollection;

import java.util.ArrayList;
import java.util.Collection;

public class DemoCollection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("����");
        coll.add("��˹");
        coll.add("��˹");
        coll.add("����");
        System.out.println(coll);

        // boolean contains(E e) �ж�o�Ƿ��ڼ����д���
        System.out.println("�ж�  ɨ��ɮ �Ƿ��ڼ�����"+coll.contains("ɨ��ɮ"));

        //boolean remove(E e) ɾ���ڼ����е�oԪ��
        System.out.println("ɾ��ʯ���죺"+coll.remove("ʯ����"));
        System.out.println("����֮�󼯺���Ԫ��:"+coll);

        // size() �������м���Ԫ��
        System.out.println("��������"+coll.size()+"��Ԫ��");

        // Object[] toArray()ת����һ��Object����
        Object[] objects = coll.toArray();
        // ��������
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        // void  clear() ��ռ���
        coll.clear();
        System.out.println("����������Ϊ��"+coll);
        // boolean  isEmpty()  �ж��Ƿ�Ϊ��
        System.out.println(coll.isEmpty());
    }
}
