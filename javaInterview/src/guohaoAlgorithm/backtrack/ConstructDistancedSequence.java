package guohaoAlgorithm.backtrack;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/25 11:18
 *
 * 1718. 构建字典序最大的可行序列
 *
 * https://leetcode-cn.com/problems/construct-the-lexicographically-largest-valid-sequence/
 */
public class ConstructDistancedSequence {

    /**
     * 代码参考：https://www.bilibili.com/video/BV1oi4y1F7vh?from=search&seid=14950413666352887470
     */
    boolean[] used = new boolean[21];// 1<=x<=20
    int[] ans;
    public int[] constructDistancedSequence(int n) {
        if (n == 1) return new int[]{1};
        ans = new int[2*n-1];
        dfs(0,n);
        return ans;
    }

    private boolean dfs(int pos, int n) {
        if (pos == 2 * n - 1)
            return true;
        if (ans[pos] > 0)
            return dfs(pos + 1, n);

        for (int i = n; i >= 1; --i) {
            if (used[i]) continue;
            if (i > 1 && (i + pos > ans.length || ans[pos + i] > 0)) continue;

            used[i] = true;
            ans[pos] = i;
            if (i > 1) ans[pos + i] = i;

            if (dfs(pos + 1, n)) return true;

            used[i] = false;
            ans[pos] = 0;
            if (i > 1) ans[pos + i] = 0;
        }
        return false;
    }
}
