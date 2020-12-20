package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 17:04
 *
 * 450. ɾ�������������еĽڵ�
 */
public class DeleteNode {
    /**
     * ɾ����Ϊ���������
     * 1�����ӽڵ�
     * 2��һ���ӽڵ�
     * 3�������ӽڵ�
     *
     *
     * һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
     * 1) �����ҵ���Ҫɾ���Ľڵ㣻
     * 2) ����ҵ��ˣ�ɾ������
     * ˵���� Ҫ���㷨ʱ�临�Ӷ�Ϊ O(h)��h Ϊ���ĸ߶ȡ�
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // �ҵ���  ����ɾ��
            //���1
            if (root.left == null && root.right == null) return null;
            // ���2
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // ���3
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            // ȥ����������
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // ȥ����������
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMin(TreeNode root) {
        // BST����ߵľ�����С��
        while (root.left != null) root = root.left;
        return root;
    }
}
