package xiaohaoAlgorithm.dynamic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/15 10:37
 * 887. ��������
 */
public class DropEgg {

    /**
     * K----�ܹ�K������
     * N ---- N��¥
     * ʱ�临�Ӷ�ΪO(KN)
     *   ��һ�����ֲ��ң�https://leetcode-cn.com/problems/super-egg-drop/solution/la-bu-la-duo-xiao-hong-mao-da-niu-ti-jie-dai-ma-ja/
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        // m��಻����N�Σ�����ɨ�裩
        int[][] dp = new int[K + 1][N + 1];
        // base case: ��K=1 ʱ�������Ա��� ����N
        //dp[0][..] = 0
        // dp[..][0] = 0
        // Ĭ�ϳ�ʼ�����鶼Ϊ0
        int m = 0;

        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                // �ܵ�¥���� = ¥�ϵ�¥���� + ¥�µ�¥���� + 1
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1; // û�鳯�ϣ����˳��£��ټ��ϵ�ǰ¥��
            }
        }
        return m;
    }

    // ���еĽⷨ��
    // https://leetcode-cn.com/problems/super-egg-drop/solution/887-ji-dan-diao-luo-dong-tai-gui-hua-er-fen-shi-ji/
    public int superEggDrop2(int K, int N) {
        // m��಻����N�Σ�����ɨ�裩
        int[][] dp = new int[K + 1][N + 1];

        int l = 1, h = N;
        /*while (l < h) {
            int mid = l + (h - l) / 2;
            if (dp[K][mid] < N) {
                l = mid + 1;
            } else {
                h = mid;
            }
            for (int k = 1; k <= K; k++) {
                // �ܵ�¥���� = ¥�ϵ�¥���� + ¥�µ�¥���� + 1
                dp[k][mid] = dp[k][mid-1] + dp[k-1][mid-1] + 1; // û�鳯�ϣ����˳��£��ټ��ϵ�ǰ¥��
            }
        }*/
        return l;
    }
}
