package javaCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("itcast");
        coll.add(5);//���ڼ���û�����κ��޶����κ����Ͷ����Ը����д��
        Iterator it = coll.iterator();
        while(it.hasNext()){
            //��Ҫ��ӡÿ���ַ����ĳ���,��Ҫ�ѵ��������Ķ���ת��String����
            String str = (String) it.next();  // ����������ʱ����������**java.lang.ClassCastException
            System.out.println(str.length());
        }
    }
}
