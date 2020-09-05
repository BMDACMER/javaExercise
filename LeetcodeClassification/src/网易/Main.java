package 网易;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/5 15:20
 *
 * 输入
 * 5
 * 10001 李华
 * 10002 张三
 * 10003 李四
 * 10005 李华
 * 10006 李四
 * 输出
 * 2
 *
 * 解释： 李华和李四分别有两人
 */
public class Main {
    /**
     * 统计重复的名字的个数   前提是至少有两人
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String[][] userInfo = new String[n][2];  // 第一列为 id 第二列为username
            HashMap<String, Integer> map = new HashMap<>(n);  // 用hashmap统计username个数大于等于2的
            for (int i = 0; i < n; i++) {
                userInfo[i][0] = scanner.next();
                userInfo[i][1] = scanner.next();
                map.put(userInfo[i][1], map.getOrDefault(userInfo[i][1],0) + 1);
            }

            int res = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2)
                    res++;
            }

            System.out.println(res);
        }
    }
}
