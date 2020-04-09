import java.util.ArrayList;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class Test26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
        // 1.�������������˫��������������ͷ�ڵ�
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 2 ��λ��������˫�������һ���ڵ�
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        // 4.�������������˫��������������ͷ�ڵ�
        TreeNode right = Convert(pRootOfTree.right);
        // 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
        if(right!=null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left!=null?left:pRootOfTree;
    }
}

