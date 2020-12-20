package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 16:57
 *
 * 701. �����������еĲ������
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // �ҵ�����λ�ã�ֱ�Ӳ����½ڵ�
        if (root == null) return new TreeNode(val);
        // ��ĿҪ���������� ��֤ ����ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ��
        // ����Ѿ����ڣ�����Ҫ�ظ�������
//        if (root.val == val) return root;   // ������ʡ��
        // val С�����������
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        // val�������������
        if (root.val < val) root.right = insertIntoBST(root.right, val);

        return root;
    }
}
