
/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */
public class Test04 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // ����������
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // �쳣����
        if (pre == null || in == null || pre.length != in.length || pre.length < 1) {
            return null;
        }

        return constructBinaryTree(pre, 0 , pre.length-1, in, 0, in.length-1);
    }

    /**
     *
     * @param pre --- ǰ�����
     * @param ps ---- ǰ�������ʼ��
     * @param pe ---- ǰ�������ֹ��
     * @param in ---- �������
     * @param ins ---- ���������ʼ��
     * @param ine ---- ���������ֹ��
     * @return ---- �ؽ���
     */
    private static TreeNode constructBinaryTree(int[] pre, int ps, int pe, int[] in, int ins, int ine) {
        // �����쳣��
        if (ps > pe || ins > ine) {
            return null;
        }

        // ǰ�������һ���ڵ�Ϊ���ڵ�
        int root = pre[ps];
        int index = ins;   // �����������Ѱ�Ҹ��ڵ�
        while (index <= ine) {
            if (in[index] == root) {
                break;  // �ҵ����ڵ�
            }
            index++;
        }

        if (index > ine) {
            throw new RuntimeException("���벻�Ϸ�");
        }

        // ������һ����ʾ�Ѿ��ҵ����ڵ�   ��ԭ������һ��Ϊ��
        TreeNode treeNode = new TreeNode(root);

        // ��������Ӧ��ǰ�������λ����[ps+1, ps+index-ins]
        // ��������Ӧ�����������λ����[ins, index-1]
        treeNode.left = constructBinaryTree(pre, ps+1, ps + index - ins, in, ins, index - 1);

        // ��������Ӧ��ǰ�������λ����[ps + index - ins +1, pe]
        // ��������Ӧ�����������λ����[index + 1, ine]
        treeNode.right = constructBinaryTree(pre, ps + index - ins +1, pe, in, index + 1, ine);

        return treeNode;
    }

    // �������������
    public static void printBinaryTree(TreeNode treeNode){
        if (treeNode != null) {
            printBinaryTree(treeNode.left);
            System.out.print(treeNode.val + " ");
            printBinaryTree(treeNode.right);
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        printBinaryTree(root);
    }
}
