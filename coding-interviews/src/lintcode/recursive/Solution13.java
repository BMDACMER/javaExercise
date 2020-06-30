package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 18:06
 * <p>
 * 337. ´ò¼Ò½ÙÉá III
 */
public class Solution13 {
    private int sumRoot = 0, sumChild = 0;

    public int rob(TreeNode root) {
        if (root == null) return 0;
        sumRoot += root.val;
        if (root.left != null) sumRoot += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) sumRoot += rob(root.right.left) + rob(root.right.right);
        sumChild += rob(root.left) + rob(root.right);
        return sumRoot > sumChild ? sumRoot : sumChild;
    }


}
