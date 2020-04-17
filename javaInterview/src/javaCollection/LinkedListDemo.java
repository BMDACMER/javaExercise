package javaCollection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();

        link.add("za");
        link.addLast("abc1");
        link.addFirst("qqq");
        System.out.println(link);

        System.out.println(link.getFirst());
        System.out.println(link.getLast());

        System.out.println(link.removeFirst());
        System.out.println(link.removeLast());
        System.out.println(link);
    }


}
