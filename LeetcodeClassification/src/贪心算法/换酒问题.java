package ̰���㷨;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 16:36
 * 1518 ��������
 * https://leetcode-cn.com/problems/water-bottles/
 */
public class �������� {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int numBo = numBottles;
        int numEx;
        while (numBo >= numExchange) {
            numEx = numBo / numExchange + numBo % numExchange; // �һ����ʣ��Ŀ�ƿ
            res += numBo / numExchange;
            numBo = numEx;   // �´ο����ڶһ��Ŀ�ƿ
        }

        return res;
    }

    public static void main(String[] args) {
        �������� m = new ��������();
        System.out.println(m.numWaterBottles(2,3));
    }
}
