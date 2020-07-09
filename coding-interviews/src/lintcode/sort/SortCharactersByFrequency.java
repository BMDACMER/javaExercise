package lintcode.sort;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/9 9:45
 *
 * 451. �����ַ�����Ƶ������
 *
 * ˼�룺��hashmapͳ���ַ����ֵĴ����������µ��ַ�����������hashmap�е�key�ĳ��ִ�������ѭ����ֵ
 * �����µ��ַ�����
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // ����listʵ��hashmap����
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 1; i <= e.getValue(); ++i) {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }

}
