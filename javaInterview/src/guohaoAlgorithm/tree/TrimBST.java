package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 10:19
 *
 * 669. �޼�����������
 */
public class TrimBST {

    /**
     * �ο��� https://leetcode-cn.com/problems/trim-a-binary-search-tree/solution/xiu-jian-er-cha-sou-suo-shu-by-leetcode/
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;

        if (root.val > high) {
            // �õ��ұ�
            root = root.left;
            root = trimBST(root, low, high);
        } else if (root.val < low) {
            // �õ����
            root = root.right;
            root = trimBST(root, low, high);
        } else {
            // �������ڣ���ȥ�õ������ӽڵ�
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
