package xiaohaoAlgorithm.tree;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/6 9:30
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return ans;
    }


    public int oneSideMax(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));

        ans = Math.max(ans, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
