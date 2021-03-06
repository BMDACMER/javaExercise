package guohaoAlgorithm.springoffer.奇安信;

import java.util.*;

/**
 * @Author guohao
 * @Date 2021/3/6 15:43
 * @Version 1.0
 */
public class Main1 {

    /**
     * 通过 40%
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最大牛奶桶数
     * @param grass int整型一维数组 吃的草的捆数
     * @param milk int整型一维数组 产的牛奶桶数
     * @return int整型
     */
    public int MaxMilk (int[] grass, int[] milk) {
        /**
         * 不会打架：
         *    1） 吃草相同
         *    2）产奶相同
         *    3）吃的草少产的奶不高于相比较的牛  等价于  吃得多产的多
         */
        if (grass == null || grass.length == 0) return 0;

        int ans = 0, n = grass.length;
        int count = milk[0];
        for (int i = 1; i < n; i++) {
            if (grass[i] == grass[i - 1] || milk[i] == milk[i - 1]) {
                count += milk[i];
            } else if (grass[i] > grass[i - 1] && milk[i] > milk[i - 1]) {
                count += milk[i];
            } else if (grass[i] < grass[i - 1] && milk[i] < milk[i - 1]) {
                count += milk[i];
            } else {
                count = milk[i];
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
