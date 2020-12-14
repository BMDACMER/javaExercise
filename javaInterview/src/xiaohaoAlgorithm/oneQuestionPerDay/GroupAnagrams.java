package xiaohaoAlgorithm.oneQuestionPerDay;

import xiaohaoAlgorithm.list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/14 16:43
 * 49. 字母异位词分组
 */
public class GroupAnagrams {
    /**
     * 基本思想：先用map统计每个字符出现的次数，将字母异位词放在同一组，即key存放各字符串字母出现的次数，
     * value：存放满足条件的字符串
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 嵌套双层的hashMap
        HashMap<HashMap<Character, Integer>, List<String>> maps = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();

       for (String s : strs) {
           char[] ch = s.toCharArray();
           // 统计每个字符出现的次数
           HashMap<Character, Integer> map = new HashMap<>();
           for (int i = 0; i < ch.length; i++) {
               map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
           }

           // 将map重新封装成一个整体，其实就是一个字符串，判断是否出现过
           if (maps.containsKey(map)) {
               // 如果出现就取出原来的value（即满足字母易位词的字符串），将当前的字符串放进去
               List<String> list = maps.get(map);
               list.add(s);
               maps.put(map, list);
           } else {
               // 当前字符串没有出现过，直接放进maps
               List<String> temp = new ArrayList<>();
               temp.add(s);
               maps.put(map, temp);
           }
       }

       // maps中的value存放的就是满足字母异位词的原字符串集合
       lists.addAll(maps.values());
       return lists;
    }
}
