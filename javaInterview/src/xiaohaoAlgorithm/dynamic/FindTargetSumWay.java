package xiaohaoAlgorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/17 19:04
 * 494. 目标和
 */
public class FindTargetSumWay {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, S);
    }

    // 备忘录
    Map<String, Integer> memo = new HashMap<>();

    private int dp(int[] nums, int i, int s) {
        // base case
        if (i == nums.length) {
            if (s == 0) return 1;
            return 0;
        }

        // 把他们转成字符串才能作为哈希表的键
        String key = i + "," + s;
        // 避免重复计算
        if (memo.containsKey(key))
            return memo.get(key);

        // 还是穷举
        int result = dp(nums, i + 1, s - nums[i]) + dp(nums, i + 1, s + nums[i]);
        // 记录备忘录
        memo.put(key, result);
        return result;
    }
}
