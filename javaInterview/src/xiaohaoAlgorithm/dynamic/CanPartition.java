package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 14:13
 * 416. �ָ�Ⱥ��Ӽ�
 */
public class CanPartition {

    /**
     * dp[i][j] = x -- ����ǰi����Ʒ����ǰ����������Ϊjʱ����xΪtrue�� ��˵��ǡ�ý�����װ��
     * ��xΪfalse��˵������ǡ�ý�����װ��
     * base case: dp[..][0] = true ��ʾ����û������ʱ��˵���Ѿ�װ����
     *             dp[0][..] = false ��ʾû����Ʒ�ˣ�˵������װ��
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int size = 0;
        for (int i = 0; i < n; i++) {
            size += nums[i];
        }
        if (size % 2 != 0) return false;

        size /= 2;
        boolean[][] dp = new boolean[n+1][size + 1];
        // base case:
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= size; j++) {
                if (j - nums[i - 1] < 0)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i - 1]];
            }
        }
        return dp[n][size];
    }


    // ��������״̬ѹ��
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int size = 0;
        for (int i = 0; i < n; i++) {
            size += nums[i];
        }
        if (size % 2 != 0) return false;

        size /= 2;
        // base case
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = size; j >= 0; --j) {
                if (j - nums[i - 1] > 0)
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }

        return dp[size];
    }
}
