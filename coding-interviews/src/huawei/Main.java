package huawei;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String str = in.next();   // 输入
        str += ",";
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            String s = "";
            while (ch[i] != ',') {
                s += ch[i++];
            }
            list.add(s);
        }

        // 将原来字符串排序 从小到大
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 统计每个字符串出现的次数
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 1);
            }else {
                map.put(list.get(i),map.get(list.get(i))+1);
            }
        }

        int max = map.get(list.get(0));
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (max < map.get(list.get(i))) {
                max = map.get(list.get(i));
                index = i;
            }
        }
        System.out.println(list.get(index));
    }

}
