package 贪心算法;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 16:13
 * 1217 玩筹码
 * https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 *
 */
public class 玩筹码 {

    /**
     * 思路：统计奇数和偶数的个数，将少的一部分移动到多的一部分上即可
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int oddSum = 0;
        int evenSum = 0;
        int res = 0;
        for (int i = 0; i < position.length; i++) {
            if ((position[i]&1) == 1)  // 等价于position[i] % 2 == 1
                oddSum++;
            else
                evenSum++;
        }
        res = oddSum < evenSum ? oddSum : evenSum;
        return res;
    }

}
