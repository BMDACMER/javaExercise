package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 21:41
 *
 * 1373. ������������������ֵ��
 */
public class MaxSumBST {

    int maxNum = 0;
    public int maxSumBST(TreeNode root) {
        /**
         * int[] res = new int[4]
         * 1) ��Ҫ�ж��Ƿ���BST   res[0]
         * 2����rootΪ���Ķ��������нڵ��е���Сֵ��  res[1]
         * 3����rootΪ���Ķ��������нڵ��е����ֵ��  res[2]
         * 4����ǰ����������������ֵ��    res[3]
         */
        dfs(root);
        return maxNum;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{
                1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
        };
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = left[3] + right[3] + root.val;
            maxNum = Math.max(maxNum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}
