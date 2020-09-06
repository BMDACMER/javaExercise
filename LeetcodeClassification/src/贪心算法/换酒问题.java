package 贪心算法;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 16:36
 * 1518 换酒问题
 * https://leetcode-cn.com/problems/water-bottles/
 */
public class 换酒问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int numBo = numBottles;
        int numEx;
        while (numBo >= numExchange) {
            numEx = numBo / numExchange + numBo % numExchange; // 兑换后可剩余的空瓶
            res += numBo / numExchange;
            numBo = numEx;   // 下次可以在兑换的空瓶
        }

        return res;
    }

    public static void main(String[] args) {
        换酒问题 m = new 换酒问题();
        System.out.println(m.numWaterBottles(2,3));
    }
}
