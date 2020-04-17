package javaCollection;


import com.sun.deploy.perf.PerfRollup;

import java.util.*;

import static java.util.Map.*;

/**
 * TreeSet �Զ�������
 *
 * ͳ���������Ӵ�С������ͬ�Ĵ�����������������
 */
public class TreeSetDemo {
    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("����",18));
        list.add(new Person("����",18));
        list.add(new Person("����",18));
        list.add(new Person("��˹",17));
        list.add(new Person("��˹",17));
        list.add(new Person("����",20));
        list.add(new Person("����",20));
        list.add(new Person("����",20));
        list.add(new Person("����",20));
        list.add(new Person("����",20));

        // ͳ�Ƴ��ֵĴ���
        Map<Person, Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))){
                map.put(list.get(i),1);
            } else {
                map.put(list.get(i),map.get(list.get(i)) + 1);
            }
        }


    }
}

