package xiaohaoAlgorithm.binarySearch;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/9 12:15
 *
 * 875. 爱吃香蕉的珂珂
 */
public class MinEatingSpeed {

    /**
     * 我们要找 “阿珂在 H 小时吃掉所有香蕉的最小速度 K”。那最笨的就是阿珂吃的特别慢，每小时只吃掉 1 根香蕉，
     * 然后我们逐渐递增阿珂吃香蕉的速度到 i，刚好满足在 H 小时可以吃掉所有香蕉，
     * 此时 i 就是我们要找的最小速度。当然，我们没有这么笨，所以可以想到使用二分的思想来进行优化。
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        //1 先求piles[]里最大的   毕竟当这堆香蕉少于 K 根，
        // 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
        int maxPile = 0;
        for (int num : piles)
            maxPile = Math.max(maxPile, num);

        int left = 1;
        int right = maxPile;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (canEat(piles, H, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += Math.ceil(pile * 1.0 / speed);
        }

        return sum > h;
    }
}
