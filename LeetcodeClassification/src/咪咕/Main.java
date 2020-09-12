package 咪咕;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/12 12:54
 * 1、找单身狗
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            HashSet<String> set = new HashSet<>();
            String str = sc.next();
            String[] s = str.split(",");
            for (int i = 0; i < s.length; i++) {
                if (!set.contains(s[i])) {
                    set.add(s[i]);
                } else {
                    set.remove(s[i]);
                }
            }
        // 剩下的最后一个就是单身狗
            for (String res : set) {
                System.out.println(res);
            }
        }
    }


}
