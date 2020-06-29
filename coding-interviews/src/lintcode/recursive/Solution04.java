package lintcode.recursive;
// 226. ��ת������
public class Solution04 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);
        return root;
    }
// ����������Ż�
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return root;
        TreeNode tmp = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(tmp);

        return root;
    }
}
