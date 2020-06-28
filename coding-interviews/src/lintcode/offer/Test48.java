package lintcode.offer;

public class Test48 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    private boolean isSymmetrical(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null && pRight == null)
            return true;
        if (pLeft == null || pRight == null)
            return false;
        if (pLeft.val != pRight.val)
            return false;
        return isSymmetrical(pLeft.left,pRight.right) && isSymmetrical(pLeft.right,pRight.left);
    }
}
