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

    /**
     * ��������
     * 1�����������嵽���ڵ����������
     * 2�����������嵽��������������ҽڵ�
     * 3�������ڵ���������ÿգ����ڵ��Ƶ��ҽڵ���
     * 4)�ظ��������� ֱ��Ϊ��
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode right = root.right;

                // �ҵ����������ҵĽڵ�
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // ���������嵽���ڵ��������λ��
                root.right = root.left;
                root.left = null;
                pre.right = right;
                root = root.right;
            }
        }
    }
}
