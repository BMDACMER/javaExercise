package 贪心算法;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 17:31
 * 860 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 *
 */
public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0) return false;
        }

        // 终止条件看five是否为零，有则true 否则false
        return true;
    }

    public static void main(String[] args) {
        柠檬水找零 m = new 柠檬水找零();
        int[] bills = {5,5,5,5,20,20,5,5,5,5};
        System.out.println(m.lemonadeChange(bills));
    }
}
