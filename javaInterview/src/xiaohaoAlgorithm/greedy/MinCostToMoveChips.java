package xiaohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 14:06
 *
 * 1217. 玩筹码
 */
public class MinCostToMoveChips {

    /**
     * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
     *   将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
     *   将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
     *   参考：
     *https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/solution/yong-tan-xin-si-xiang-lai-zhao-gui-lu-chao-xiang-x/
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if ((position[i] & 1) == 0) even++;
            else odd++;
        }
        return even > odd ? odd :even;
    }
}
