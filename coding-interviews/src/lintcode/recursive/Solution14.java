package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/1 22:24
 * 671. �������еڶ�С�Ľڵ�
 *
 * һ���ڵ�Ҫô���� 0 ���� 2 ���ӽڵ㣬������ӽڵ㣬��ô���ڵ�����С�Ľڵ㡣
 */
public class Solution14 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(
                root.right);
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal
                , rightVal);
        if (leftVal != -1) return leftVal;
        return rightVal;
    }
}
