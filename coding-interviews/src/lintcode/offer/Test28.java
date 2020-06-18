package lintcode.offer;

public class Test28 {
    public int RectCover(int target) {
        if (target <= 2)
            return target;
        int pre1 = 1, pre2 = 2;
        int result = 1;
        for (int i = 2; i < target; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
