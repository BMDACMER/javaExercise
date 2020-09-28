package ¶ÈÐ¡Âú;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/20 20:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            int res = help(str1, str2);
            System.out.println(res);
        }
    }

    private static int help(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries1 = map.entrySet();
        int temp = 0;
        for (Map.Entry<Character, Integer> entry : entries1) {
            if (map2.containsKey(entry.getKey())) {
                temp += map2.get(entry.getKey()) < entry.getValue() ? map2.get(entry.getKey()) : entry.getValue();
            }
        }
        return temp;
    }
}
