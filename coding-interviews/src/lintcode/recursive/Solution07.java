package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 15:16
 * <p>
 * 437  ͳ��·���͵���һ������·������
 */
public class Solution07 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int resRoot = pathSumStartWithRoot(root, sum);
        int resLeft = pathSum(root.left, sum);
        int resRight = pathSum(root.right, sum);
        return resRoot + resLeft + resRight;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int sumRoot = root.val == sum ? 1 : 0;
        int sumLeft = pathSumStartWithRoot(root.left, sum - root.val);
        int sumRight = pathSumStartWithRoot(root.right, sum - root.val);
        return sumRoot + sumLeft + sumRight;
    }
}
