package ̰���㷨;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 17:03
 * 1046 ���һ��ʯͷ������
 * https://leetcode-cn.com/problems/last-stone-weight/
 */
public class ���һ��ʯͷ������ {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        // ����
        Arrays.sort(stones);
        while (stones[stones.length - 2] != 0) {
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }


}
