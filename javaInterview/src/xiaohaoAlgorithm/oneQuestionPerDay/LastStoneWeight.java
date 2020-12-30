package xiaohaoAlgorithm.oneQuestionPerDay;

import javabase.Array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/30 9:23
 *
 * 1046. 最后一块石头的重量
 */
public class LastStoneWeight {

    /**
     * 暴力算法
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);

        int index = stones.length - 2;
        while (index >= 0) {
            stones[index] = Math.abs(stones[index] - stones[index + 1]);
            if (stones[index] != 0) {
                for (int i = 0; i < index; i++) {
                    if (stones[index] < stones[i]) {
                        int tmp = stones[index];
                        for (int j = index; j > i; j--) {
                            stones[j] = stones[j - 1];
                        }
                        stones[i] = tmp;
                    }
                }
                index--;
            } else {
                index -= 2;
            }

        }

        return stones[0];
    }

    // 方法二
    public int lastStoneWeight2(int[] stones) {
        if (stones.length == 1) return stones[0];
        Arrays.sort(stones);

        int index = stones.length - 2;
        while (stones[index] != 0) {
            stones[index] = Math.abs(stones[index] - stones[index + 1]);
            stones[index + 1] = 0;
            Arrays.sort(stones);
            index = stones.length - 2;
        }

        return stones[stones.length - 1];
    }

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(l.lastStoneWeight(stones));
    }
}
