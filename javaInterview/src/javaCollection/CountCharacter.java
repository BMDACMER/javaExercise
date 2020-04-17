package javaCollection;

import java.util.*;

/**
 * ͳ���ַ������ַ����ֵĴ�����������������
 */
public class CountCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        while (in.hasNext()) {
            str = in.next();
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (!map.containsKey(chs[i])) {
                    map.put(chs[i], 1);
                } else {
                    map.put(chs[i], map.get(chs[i]) + 1);
                }
            }

//            // ����һ
//            Set<Map.Entry<Character,Integer>> set = map.entrySet();
//            for (Map.Entry<Character,Integer> entry : set) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
//
//            System.out.println("------------------------------------");
//            // ������
//            for (Character key : map.keySet()) {
//                System.out.println(key + ":" + map.get(key));
//            }

            // �����ִ�����������
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();
            for (Map.Entry<Character,Integer> entry : map.entrySet()) {
                list.add(entry);
            }

            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            for (Map.Entry<Character,Integer> entry : list) {
                System.out.println(entry.getKey() +":" + entry.getValue());
            }
        }
    }
}
