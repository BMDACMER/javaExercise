/**
 *  输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Test40 {

    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(Test39.TreeNode root) {
        // 平衡二叉树默认为 二叉排序树
        if (root == null) {
            return false;
        }

        getDepth(root);

        return isBalanced;
    }

    private int getDepth(Test39.TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (isBalanced) {  // 剪枝操作

            if (Math.abs(right - left) > 1) {
                isBalanced = false;
            } else {
                isBalanced = true;
            }

            return right>left ?right+1:left+1;
        }
        return 0;   // 返回什么已经不重要了。因为此时isBalanced已经为false
    }
}
