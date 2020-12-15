package xiaohaoAlgorithm.dynamic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/15 10:37
 * 887. 鸡蛋掉落
 */
public class DropEgg {

    /**
     * K----总共K个鸡蛋
     * N ---- N层楼
     * 时间复杂度为O(KN)
     *   另一个二分查找：https://leetcode-cn.com/problems/super-egg-drop/solution/la-bu-la-duo-xiao-hong-mao-da-niu-ti-jie-dai-ma-ja/
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        // m最多不超过N次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        // base case: 当K=1 时，成线性遍历 返回N
        //dp[0][..] = 0
        // dp[..][0] = 0
        // 默认初始化数组都为0
        int m = 0;

        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                // 总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1; // 没碎朝上，碎了朝下，再加上当前楼层
            }
        }
        return m;
    }

    // 大佬的解法：
    // https://leetcode-cn.com/problems/super-egg-drop/solution/887-ji-dan-diao-luo-dong-tai-gui-hua-er-fen-shi-ji/
    public int superEggDrop2(int K, int N) {
        // m最多不超过N次（线性扫描）
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
                // 总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1
                dp[k][mid] = dp[k][mid-1] + dp[k-1][mid-1] + 1; // 没碎朝上，碎了朝下，再加上当前楼层
            }
        }*/
        return l;
    }
}
