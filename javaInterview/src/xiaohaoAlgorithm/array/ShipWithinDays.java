package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 10:02
 *
 * 1011. 在 D 天内送达包裹的能力
 */
public class ShipWithinDays {

    /**
     * 此题与吃香蕉思路一样   二分查找
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights);
        int right = getSum(weights) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] weights, int day, int w) {
        int i = 0;
        for (int d = 0; d < day; d++) {
            int canWeight = w;
            while ((canWeight -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) return true;
            }
        }
        return false;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }

    private int getMax(int[] weights) {
        int max = weights[0];
        for (int w : weights) {
            if (max < w)
                max = w;
        }
        return max;
    }

    public static void main(String[] args) {
        ShipWithinDays s = new ShipWithinDays();
        int[] w = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(s.shipWithinDays(w,D));
    }
}
