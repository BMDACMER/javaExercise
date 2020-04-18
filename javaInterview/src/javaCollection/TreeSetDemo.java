package javaCollection;


import com.sun.deploy.perf.PerfRollup;

import java.util.*;

import static java.util.Map.*;

/**
 * TreeSet 自定义排序
 *
 * 统计人名，从大到小排序，相同的次数，则按照名字排序
 */
public class TreeSetDemo {
    public static void main(String[] args) {
/**
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三",18));
        list.add(new Person("张三",18));
        list.add(new Person("张三",18));
        list.add(new Person("里斯",17));
        list.add(new Person("里斯",17));
        list.add(new Person("王五",20));
        list.add(new Person("王五",20));
        list.add(new Person("王五",20));
        list.add(new Person("王五",20));
        list.add(new Person("王五",20));

        // 统计出现的次数
        Map<Person, Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))){
                map.put(list.get(i),1);
            } else {
                map.put(list.get(i),map.get(list.get(i)) + 1);
            }
        }
*/

        Map<String,String> map = new TreeMap<>();
        map.put("a","ddddd");
        map.put("b","dsfa");
        map.put("d","rttt");
        map.put("c","bbbbbb");

        List<Entry<String,String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, String>>() {
            @Override
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                // 升序排序
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Entry<String, String> e : list) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
}

