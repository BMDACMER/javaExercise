package javaCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("abc");
        list.add("itcast");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.print(s + ":" + s.length() + "\n");
        }
    }
}
