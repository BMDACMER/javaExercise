package guohaoAlgorithm.leetcodeCompettition;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/17 10:33
 */
public class CountGoodRectangles {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = Integer.MIN_VALUE;
        int tmp;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            tmp = Math.min(rectangles[i][0], rectangles[i][1]);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            maxLen = Math.max(maxLen, tmp);
        }

        return map.get(maxLen);
    }
}
