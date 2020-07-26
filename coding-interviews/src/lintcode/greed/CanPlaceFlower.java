package lintcode.greed;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/26 22:16
 * 605. 种花问题
 * <p>
 * 思路：统计可以种植的花，在和n比较，要求n<=可种植的花  返回true 否则，返回false
 * 种植花的算法： 如果下标i表示的值是0 在判断下一个
 * 如果是0 则统计count++
 * 否则，i跳转到i=i+2
 * 是1 直接下一个，重复上述动作
 * 直到遍历完毕
 */
public class CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int[] tmp = new int[flowerbed.length + 2];
        tmp[flowerbed.length + 1] = 0;
        tmp[0] = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            tmp[i+1] = flowerbed[i];
        }

        for (int i = 1; i < tmp.length-1; i++) {
            if (tmp[i-1] == 0 && tmp[i] == 0 && tmp[i+1] == 0) {
                count++;
                tmp[i] = 1;
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlower canPlaceFlower = new CanPlaceFlower();
        int[] flowerbed = new int[]{0,0,1,0,0};
        System.out.println(canPlaceFlower.canPlaceFlowers(flowerbed, 1));
        ;
    }
}
