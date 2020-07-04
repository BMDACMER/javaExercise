package lintcode.stock;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/4 22:47
 * <p>
 * 123. 买卖股票的最佳时机 III
 */
public class BuyStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int min = prices[0];            // 初始化的前半部分最小买入价格
        int max = prices[len - 1];      // 初始化的后半部分最大卖出价格

        int maxPro1 = 0;                // 前半部分的每天最大利润
        int maxPro2 = 0;                // 后半部分的每天最大利润

        int[] profit1 = new int[len];   // 前半部分的利润表
        int[] profit2 = new int[len];   // 后半部分的利润表

        for (int i = 0; i < len; i++) {

            // 1. 计算 从前往后 的利润
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                maxPro1 = Math.max(maxPro1, prices[i] - min);
            }
            profit1[i] = maxPro1;

            //  2. 计算 从后往前 的利润
            if (prices[len - 1 - i] >= max) {
                max = prices[len - 1 - i];
            } else {
                maxPro2 = Math.max(maxPro2, max - prices[len - 1 - i]);
            }
            profit2[len - i - 1] = maxPro2;
        }

        // 3. 计算利润和，求最大值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, profit1[i] + profit2[i]);
        }
        return res;
    }
}


