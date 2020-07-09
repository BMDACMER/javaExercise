package lintcode.sort;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/9 9:45
 *
 * 451. 根据字符出现频率排序
 *
 * 思想：用hashmap统计字符出现的次数，定义新的字符串，用来从hashmap中的key的出现次数来来循环赋值
 * 构建新的字符串。
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 借助list实现hashmap排序
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
