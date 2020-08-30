package 滑动数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 14:25
 *
 * 220. 存在重复元素 III
 *
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class 存在重复元素III {
    /**
     * 方法一：暴力算法  通过 耗时703 ms，在所有 Java 提交中击败了5.07%的用户
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) return false;

        int count = 0;
        long tt = t;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(i - j) <= k && Math.abs(((long)nums[i] - (long)nums[j])) <= tt)
                    count++;
            }
        }
        return count > 0;
    }

    /**
     * 方法二： 散列表  + 桶
     * 参考：https://leetcode-cn.com/problems/contains-duplicate-iii/solution/marvelzhong-deng-de-xue-xi-bi-ji-220-by-tyanyoneca/
     * 时间复杂度：超越93%的java用户
     */

    private int sz;//桶大小

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(t < 0)    return false; //绝对值不可能为负
        sz = t + 1;
        Map<Integer, Long> map = new HashMap<>(); //哈希表，桶号映射到值，值用Long防止溢出
        for(int i = 0; i < nums.length; i++)
        {
            int key = getID(nums[i]); //得到桶号
            if(map.containsKey(key)) // 同一个桶，差的绝对值必然满足要求
                return true;
            if(map.containsKey(key - 1) && Math.abs(map.get(key - 1) - nums[i]) <= t) //检查相邻桶
                return true;
            if(map.containsKey(key + 1) && Math.abs(map.get(key + 1) - nums[i]) <= t)
                return true;
            map.put(key, (long)nums[i]); //将该值放入桶中
            if(i >= k)    map.remove(getID(nums[i - k]));//为了始终满足下标的差的绝对值要求
        }
        return false;
    }
    /*计算桶号*/
    private int getID(int num) {
        return (num < 0) ? num / sz - 1 : num / sz; //防止0号桶同时存在正负数干扰判断
    }

}

/*
[2147483647,-2147483647]
1
2147483647
 */