/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 参考：https://www.nowcoder.com/profile/562667/codeBookDetail?submissionId=1523155
 */
public class Test17 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) return false; // 空树不是任意一个树的子结构
        if (root1 == null && root2 != null) return false;

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSubTree(root1,root2);
        }

        if (!flag) {
            flag = HasSubtree(root1.left, root2);
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;   // 说明查找结束了
        if (root1 == null && root2 != null) return false;
        if (root1.val == root2.val) {
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
        } else {
            return false;
        }
    }

}
