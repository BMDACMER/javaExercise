package guohaoAlgorithm.tree;

import guohaoAlgorithm.dynamic.MaxProfitI;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 15:39
 *
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {

    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSide(root);
        return sum;
    }


    private int oneSide(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, oneSide(root.left));
        int right= Math.max(0, oneSide(root.right));
        sum = Math.max(sum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
