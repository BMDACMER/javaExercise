package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 15:54
 *
 * 99. »Ö¸´¶þ²æËÑË÷Ê÷ hard
 */
public class RecoverTree {

    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        traverse(root.right);
    }
}
