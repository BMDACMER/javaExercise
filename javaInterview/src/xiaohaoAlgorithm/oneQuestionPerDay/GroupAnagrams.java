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
 * 49. ��ĸ��λ�ʷ���
 */
public class GroupAnagrams {
    /**
     * ����˼�룺����mapͳ��ÿ���ַ����ֵĴ���������ĸ��λ�ʷ���ͬһ�飬��key��Ÿ��ַ�����ĸ���ֵĴ�����
     * value����������������ַ���
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Ƕ��˫���hashMap
        HashMap<HashMap<Character, Integer>, List<String>> maps = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();

       for (String s : strs) {
           char[] ch = s.toCharArray();
           // ͳ��ÿ���ַ����ֵĴ���
           HashMap<Character, Integer> map = new HashMap<>();
           for (int i = 0; i < ch.length; i++) {
               map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
           }

           // ��map���·�װ��һ�����壬��ʵ����һ���ַ������ж��Ƿ���ֹ�
           if (maps.containsKey(map)) {
               // ������־�ȡ��ԭ����value����������ĸ��λ�ʵ��ַ�����������ǰ���ַ����Ž�ȥ
               List<String> list = maps.get(map);
               list.add(s);
               maps.put(map, list);
           } else {
               // ��ǰ�ַ���û�г��ֹ���ֱ�ӷŽ�maps
               List<String> temp = new ArrayList<>();
               temp.add(s);
               maps.put(map, temp);
           }
       }

       // maps�е�value��ŵľ���������ĸ��λ�ʵ�ԭ�ַ�������
       lists.addAll(maps.values());
       return lists;
    }
}
