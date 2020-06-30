package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 15:05
 * <p>
 * 112.路经总和   https://leetcode-cn.com/problems/path-sum/
 */
public class Solution06 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // 遍历到叶子节点  终止条件
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
