package javaCollection;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add(new String("cba"));
        set.add("vdf");
        set.add("243d");
        for (String str : set){
            System.out.println(str);
        }
    }
}
