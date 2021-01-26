package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 11:11
 *
 * 312. ������
 * �� n �����򣬱��Ϊ0 �� n - 1��ÿ�������϶�����һ�����֣���Щ���ִ������� nums �С�
 *
 * ����Ҫ����������е����򡣴��Ƶ� i ����������Ի�� nums[i - 1] * nums[i] * nums[i + 1] öӲ�ҡ�
 * ����� i - 1 �� i + 1 ����� i ���ڵ������������š���� i - 1�� i + 1 ����������ı߽磬
 * ��ô�͵�����һ������Ϊ 1 ������
 *
 * �����ܻ��Ӳ�ҵ����������
 *
 *
 *
 * ʾ�� 1��
 * ���룺nums = [3,1,5,8]
 * �����167
 * ���ͣ�
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 */
public class MaxCoins {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 1) ��ԭ������������1
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }

        // 2) ����dp[i][j] ---- (i,j)�����ڴ������������õ����ֵ
        // dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + nums[i]*nums[k]*nums[j])
        // base case: dp[i][..] = dp[..][j] = 0
        int[][] dp = new int[n+2][n+2];
        for (int i = n; i >= 0; --i) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j]+ arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
