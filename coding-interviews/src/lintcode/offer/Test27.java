package lintcode.offer;

public class Test27 {
    public int JumpFloor(int target) {
        if (target <= 2)
            return target;
        int pre1 = 1, pre2 = 2;
        int sum = 1;
        for (int i = 2; i < target; i++) {
            sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }
        return sum;
    }
}
