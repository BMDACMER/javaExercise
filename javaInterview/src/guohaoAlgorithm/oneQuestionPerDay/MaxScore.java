package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/6 8:56
 *
 * 1423. 可获得的最大点数
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * 示例 2：
 *
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 */
public class MaxScore {

    /**
     * 由于剩余卡牌是连续的，使用一个固定长度为 n-kn?k 的滑动窗口对数组cardPoints 进行遍历，
     * 求出滑动窗口最小值，然后用所有卡牌的点数之和减去该最小值，即得到了拿走卡牌点数之和的最大值。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/solution/ke-huo-de-de-zui-da-dian-shu-by-leetcode-7je9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        // 1 <= k <= cardPoints.length
        if (cardPoints == null || cardPoints.length == 0 || k == 0) return 0;

        int window = cardPoints.length - k;   // 因为是连续的，找出最小和即可
        int sum = 0;
        for (int i = 0; i < window; i++) {
            sum += cardPoints[i];
        }
        int min = sum;
        for (int i = window; i < cardPoints.length; i++) {
            sum += cardPoints[i] - cardPoints[i - window];
            min = Math.min(min, sum);
        }

        return Arrays.stream(cardPoints).sum() - min;
    }
}
