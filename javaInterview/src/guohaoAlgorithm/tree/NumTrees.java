package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 20:32
 *
 * 96. 不同的二叉搜索树
 */
public class NumTrees {

    int[][] memo;
    public int numTrees(int n) {
        if (n <= 1) return n;
        memo = new int[n+1][n+1];
        return countTrees(1, n);
    }

    private int countTrees(int low, int high) {
        if (low >= high) return 1;

        if (memo[low][high] != 0) return memo[low][high];
        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = countTrees(low, i - 1);
            int right = countTrees(i + 1, high);
            res += left * right;
        }
        memo[low][high] = res;
        return res;
    }
}
