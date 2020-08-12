import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/12 20:40
 *
 * ·Ö¸î×Ö·û´®
 */
public class HJ5 {
    @Override
    public String toString() {
        return "HJ5{}";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);

        while (n != 0) {
            String temp = br.readLine();
            List<ArrayList<Character>> lists = new ArrayList<>();
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < temp.length(); i++) {
                list.add(temp.charAt(i));
                if (list.size() % 8 == 0) {
                    lists.add(list);
                    list = new ArrayList<>();
                }
            }

            while (list.size() < 8) {
                list.add('0');
            }
            lists.add(list);

            for (ArrayList<Character> arrayList : lists) {
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.print(arrayList.get(i));
                }
                System.out.println();
            }

            n--;
        }


    }
}
