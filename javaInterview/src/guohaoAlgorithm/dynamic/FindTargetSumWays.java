package guohaoAlgorithm.dynamic;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 22:55
 *
 * 0-��������
 *
 * 494. Ŀ���
 * ����һ���Ǹ��������飬a1, a2, ..., an, ��һ��Ŀ������S������������������ + �� -�����������е�����һ���������㶼���Դ� + �� -��ѡ��һ������������ǰ�档
 *
 * ���ؿ���ʹ���������ΪĿ���� S ���������ӷ��ŵķ�������
 *
 *
 * ʾ����
 *
 * ���룺nums: [1, 1, 1, 1, 1], S: 3
 * �����5
 * ���ͣ�
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * һ����5�ַ���������Ŀ���Ϊ3��
 */
public class FindTargetSumWays {

    // ��̬�滮  ��ά
    public int findTargetSumWays(int[] nums, int S) {
        /**
         *
         * max = sum(nums) * 2 -1  // - 0 +
         * dp[i][max+s] ---- ǰi��Ԫ��ͨ��+/-�ܹ���ʾs�ķ�����, max�൱�ڴ���0���λ��
         * dp[0][s] = 1;   //ֻ��һ�ַ���
         * dp[i][s] = dp[i-1][s+nums[i-1]] + dp[i-1][s-nums[i-1]]
         */

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(S) > sum) return 0; // �ܺ�С��s�Ŀ϶����ܴճ�   ֱ�ӷ���0
        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][sum] = 1;  // �൱��λ�� ԭ��λ��
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                int l = j - nums[i -1] >= 0 ? j - nums[i -1] : 0;
                int r = j + nums[i - 1] <= 2 * sum ? j + nums[i - 1] : 2 * sum;
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }
        return dp[n][sum+S];
    }

    /**
     * תΪ�����Ӽ�    0-1��������
     * ��ά�Ļᳬ���ڴ�����
     * [1,2,7,9,981]
     * 1000000000
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        /**
         * sub(A) - sub(B) = target
         * sub(A) = sub(b) + target
         * sub(A) + sub(A) = sub(A) + sub(B) + target
         * 2*sub(A) = sum(nums) + target
         */
        int sum = 0;
        for (int num : nums) sum += num;
        sum = sum + S;
        // ����Ŀת��Ϊ �����Ӽ� 416. �ָ�Ⱥ��Ӽ�
        if (sum % 2 != 0) return 0;

        sum /= 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        // dp[0][..] = 0. dp[..][0] = 1  ת��Ϊ01��������
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    /**
     * תΪ�����Ӽ�    0-1��������    �Ż��ռ�   ��ϸ�ο�P212-215
     * ����90%�û�
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays3(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < S || (sum + S) % 2 == 1) return 0;
        sum += S;
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i-1]) {
                    dp[j] = dp[j] + dp[j - nums[i-1]];
                }
            }
        }
        return dp[sum];
    }



    // dfs ���ݷ�
    public int findTargetSumWaysDFS(int[] nums, int S) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, S);
    }

    HashMap<String, Integer> memo = new HashMap<>();
    private int dp(int[] nums, int index, int s) {
        if (index == nums.length){
            if (s == 0) return 1;
            return 0;
        }

        String key = index + "," + s;
        if (memo.containsKey(key)) return memo.get(key);
        int res = dp(nums, index + 1, s + nums[index]) + dp(nums, index + 1, s - nums[index]);
        memo.put(key, res);
        return res;
    }
}