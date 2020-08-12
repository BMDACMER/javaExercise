import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/12 21:42
 *
 * ×Ö·û´®Í³¼Æ
 */
public class HJ6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(input);
            HashMap<Character, Integer> map = new HashMap<>(127);
            // Í³¼Æ
            for (int i = 0; i < sb.length(); i++) {
                map.put(sb.charAt(i),map.getOrDefault(sb.charAt(i), 0) + 1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            // ÅÅÐò
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    if (o1.getValue() != o2.getValue()) {
                        return -o1.getValue().compareTo(o2.getValue());  // ½µÐò
                    } else {
                        return o1.getKey().compareTo(o2.getKey());   // ÉýÐò
                    }
                }
            });

            for(Map.Entry<Character, Integer> mapping:list){
                System.out.print(mapping.getKey());
            }
            System.out.println();
        }
    }
}
