/**
 *  ����һ�ö��������жϸö������Ƿ���ƽ���������
 */
public class Test40 {

    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(Test39.TreeNode root) {
        // ƽ�������Ĭ��Ϊ ����������
        if (root == null) {
            return false;
        }

        getDepth(root);

        return isBalanced;
    }

    private int getDepth(Test39.TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (isBalanced) {  // ��֦����

            if (Math.abs(right - left) > 1) {
                isBalanced = false;
            } else {
                isBalanced = true;
            }

            return right>left ?right+1:left+1;
        }
        return 0;   // ����ʲô�Ѿ�����Ҫ�ˡ���Ϊ��ʱisBalanced�Ѿ�Ϊfalse
    }
}
