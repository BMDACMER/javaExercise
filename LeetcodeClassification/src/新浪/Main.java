package ����;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/13 16:07
 * 1����  pass
 *
 * 2���ظ��ַ�ɸ��
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            boolean res = singleChar(str);
            System.out.println(res);
        }
    }

    /**
     * �ظ��ַ�ɸ��,
     * Ҫ��ʱ�临�Ӷ�ΪO(nlogn) �ռ临�Ӷ�ΪO(1)������ʹ���������
     * @param str
     * @return
     */
    private static boolean singleChar(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 1) {
                return false;
            }
        }
        return true;
    }
}
