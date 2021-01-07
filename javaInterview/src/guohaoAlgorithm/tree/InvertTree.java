package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 17:24
 *
 * 226. ��ת������
 */
public class InvertTree {

    /**
     * �㷨˼·�����������Ľڵ����������Ľڵ㻥��������ǰ��or�����������
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // ǰ�����
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
