package xiaohaoAlgorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/17 19:04
 * 494. Ŀ���
 */
public class FindTargetSumWay {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, S);
    }

    // ����¼
    Map<String, Integer> memo = new HashMap<>();

    private int dp(int[] nums, int i, int s) {
        // base case
        if (i == nums.length) {
            if (s == 0) return 1;
            return 0;
        }

        // ������ת���ַ���������Ϊ��ϣ��ļ�
        String key = i + "," + s;
        // �����ظ�����
        if (memo.containsKey(key))
            return memo.get(key);

        // �������
        int result = dp(nums, i + 1, s - nums[i]) + dp(nums, i + 1, s + nums[i]);
        // ��¼����¼
        memo.put(key, result);
        return result;
    }
}
