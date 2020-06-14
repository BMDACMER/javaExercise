package leetcode.mockInterview;

import java.util.HashMap;
import java.util.Map;

public class LuckyNumber {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int findLucky(int[] arr) {
        int luckNum = -1;
        // ͳ��ÿ�����ֳ��ֵĴ���
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        // ����
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            // ����ҵ���߼�
            if (entry.getKey() == entry.getValue()) {
                if (luckNum < entry.getKey()) {
                    luckNum = entry.getKey();
                }
            }
        }
        return luckNum;
    }
}
