package xiaohaoAlgorithm.array;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 15:17
 *
 * 560. ��ΪK��������
 */
public class SubarraySum {
    /**
     * �����㷨
     * ˼�룺ͳ��numsǰi��������ĺͣ�Ȼ����nums[j + 1] - nums[i]��������[i,j]֮����������
     * �ж� ���������k��ֵ  count++   ���ؼ���
     * @param nums
     * @param k
     * @return
     */
   /* public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;  // ��ʾǰ0��Ԫ�صĺ�Ϊ0��Ҳ��û��������  �Ϳ϶�Ϊ0��
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                if (sum[j] - sum[i] == k)
                    count++;
            }
        }
        return count;
    }*/


    /**
     * �Ż��㷨
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // map--> ������ĺ�  �Լ����ֵĴ���
        HashMap<Integer, Integer> map = new HashMap<>();
        // base case
        map.put(0,1);
        int sum_i = 0, sum_j = 0;
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum_i += nums[i];
            sum_j = sum_i - k;
            if (map.containsKey(sum_j)) {
                ans += map.get(sum_j);
            }
            map.put(sum_i, map.getOrDefault(sum_i,0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        SubarraySum s = new SubarraySum();
        int[] nums = {1,1,1,2};
        int k = 2;
        System.out.println(s.subarraySum(nums, k));
    }
}
