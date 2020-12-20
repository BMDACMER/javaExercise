package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 16:11
 *
 * 98. ÑéÖ¤¶þ²æËÑË÷Ê÷
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST2(root, null, null);
    }

    private boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST2(root.left, min, root) && isValidBST2(root.right, root, max);
    }
}
