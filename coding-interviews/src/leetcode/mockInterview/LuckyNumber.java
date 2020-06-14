package leetcode.mockInterview;

import java.util.HashMap;
import java.util.Map;

public class LuckyNumber {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int findLucky(int[] arr) {
        int luckNum = -1;
        // 统计每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        // 遍历
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            // 处理业务逻辑
            if (entry.getKey() == entry.getValue()) {
                if (luckNum < entry.getKey()) {
                    luckNum = entry.getKey();
                }
            }
        }
        return luckNum;
    }
}
