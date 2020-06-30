package lintcode.recursive;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/6/30 15:53
 * <p>
 * 572. 另一个树的子树
 */
public class Solution08 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val)
            return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
