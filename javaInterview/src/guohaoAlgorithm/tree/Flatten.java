package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 23:08
 *
 * 114. ������չ��Ϊ����
 */
public class Flatten {

    /**
     * �㷨˼·�������������������ֱ�flatten  ���������ŵ�����������  Ȼ��������������Ϊ������
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        /// ��������λ��
        // ���������Ѿ�����ƽ��һ������
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2  ����������Ϊ������
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }
}
