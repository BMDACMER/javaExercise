/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 *
 * �ο���https://www.nowcoder.com/profile/562667/codeBookDetail?submissionId=1523155
 */
public class Test17 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) return false; // ������������һ�������ӽṹ
        if (root1 == null && root2 != null) return false;

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSubTree(root1,root2);
        }

        if (!flag) {
            flag = HasSubtree(root1.left, root2);
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;   // ˵�����ҽ�����
        if (root1 == null && root2 != null) return false;
        if (root1.val == root2.val) {
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
        } else {
            return false;
        }
    }

}
