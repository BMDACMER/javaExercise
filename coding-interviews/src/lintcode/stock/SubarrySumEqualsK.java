package lintcode.stock;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/3 21:58
 *
 * 560. ����һ�����������һ������k������Ҫ�ҵ��ܺ͵���k�������������������
 */
public class SubarrySumEqualsK {
    // ������
    /**
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    } */

    // ��Ч�㷨
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;   // ͳ�ƴ���
        int sum = 0;  // ͳ��������֮��
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);  // ��ʼ��
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                cnt += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }
}
