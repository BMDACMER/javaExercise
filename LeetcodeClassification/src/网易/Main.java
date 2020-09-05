package ����;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/5 15:20
 *
 * ����
 * 5
 * 10001 �
 * 10002 ����
 * 10003 ����
 * 10005 �
 * 10006 ����
 * ���
 * 2
 *
 * ���ͣ� ������ķֱ�������
 */
public class Main {
    /**
     * ͳ���ظ������ֵĸ���   ǰ��������������
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String[][] userInfo = new String[n][2];  // ��һ��Ϊ id �ڶ���Ϊusername
            HashMap<String, Integer> map = new HashMap<>(n);  // ��hashmapͳ��username�������ڵ���2��
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
