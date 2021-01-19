package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 14:54
 *
 * 938. �����������ķ�Χ��
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int ans = 0;
        if (root.val > high) {
            // �ڵ��������ұ߽磬�Ͱ��ҽڵ�ȫ������
            root = root.left;
            // �ü��󣬼�������ڵ�
            ans = rangeSumBST(root, low, high);
        } else if (root.val < low) {
            // �ڵ���С����߽磬����ڵ�ȫ������
            root = root.right;
            // �ü��󣬼������ҽڵ�
            ans = rangeSumBST(root, low, high);
        }else {
            // ����Ľڵ�ֵ��[low, high]�����ڣ�
            int left = rangeSumBST(root.left, low, high);
            int right = rangeSumBST(root.right, low, high);
            // �����������Ľڵ�ֵ�͵�ǰ�ڵ�ֵȫ���ۼӵ�ans�ϼ���
            ans = left+right+root.val;
        }

        return ans;
    }
}
