package javaCollection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // �� β����� ָ��Ԫ��
        list.add("ͼͼ");
        list.add("С��");
        list.add("������");
        System.out.println(list);
        // add(int index,String s) ��ָ��λ�����
        list.add(1, "ûͷ��");
        System.out.println(list);
        // String remove(int index) ɾ��ָ��λ��Ԫ�� ���ر�ɾ��Ԫ��
        // ɾ������λ��Ϊ2��Ԫ��
        System.out.println("ɾ������λ��Ϊ2��Ԫ��");
        System.out.println(list.remove(2));

        System.out.println(list);
        // String set(int index,String s)
        // ��ָ��λ�� ���� Ԫ��������ģ�
        // �޸�ָ��λ��Ԫ��
        list.set(0, "��ë");
        System.out.println(list);
        // String get(int index) ��ȡָ��λ��Ԫ��
        // ��size() ����һ���� �� ������
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
