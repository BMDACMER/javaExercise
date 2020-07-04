package lintcode.stock;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/4 22:47
 *
 * 123. 买卖股票的最佳时机 III
 */
public class BuyStock3 {
    int interest = 0;
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] tmp = new int[prices.length - 1];
        Arrays.fill(tmp,0);
        int start = prices[0];
        int j = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] < 0) {
                tmp[j++] = prices[i - 1] - start;
                start = prices[i];

            }
        }
        if (j < prices.length - 1)
            tmp[j] = prices[prices.length - 1] - start;
//        MyCompare mc = new MyCompare();
//        Arrays.sort(tmp,mc);
        Arrays.sort(tmp);
        if (tmp[j] > 0) interest += tmp[j];
        if (tmp[j-1] > 0) interest += tmp[j-1];

        return interest;
    }

    public static void main(String[] args) {
        BuyStock3 b = new BuyStock3();
        int[] arr = {7,6,4,3,1};
        System.out.println(b.maxProfit(arr));
    }
}


/***
//外部比较器
class MyCompare implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return o1 > o2 ? -1 :(o1==o2 ? 0 :1);
    }

    @Override
    public Comparator<Integer> reversed() {
        return null;
    }


}
?*/
