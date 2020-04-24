package lintcode.offer;

/**
 * ������07. �ؽ�������
 * <p>
 * ����ĳ��������ǰ���������������Ľ�������ؽ��ö����������������ǰ���������������Ľ���ж������ظ������֡�
 */
public class Test05 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length < 1) {
            return null;
        }

        return rebuildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode rebuildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        // �����쳣��
        if (ps > pe || is > ie) {
            return null;
        }

        // ǰ�������һ���ڵ�Ϊ���ڵ�
        int root = preorder[ps];
        int index = is;   // �����������Ѱ�Ҹ��ڵ�
        while (index <= ie) {
            if (inorder[index] == root) {
                break;  // �ҵ����ڵ�
            }
            index++;
        }

        if (index > ie) {
            throw new RuntimeException("���벻�Ϸ�");
        }
sta
        // ������һ����ʾ�Ѿ��ҵ����ڵ�   ��ԭ������һ��Ϊ��
        TreeNode treeNode = new TreeNode(root);

        // ��������Ӧ��ǰ�������λ����[ps+1, ps+index-ins]
        // ��������Ӧ�����������λ����[ins, index-1]
        treeNode.left = rebuildTree(preorder, ps+1, ps + index - is, inorder, is, index - 1);

        // ��������Ӧ��ǰ�������λ����[ps + index - ins +1, pe]
        // ��������Ӧ�����������λ����[index + 1, ine]
        treeNode.right = rebuildTree(preorder, ps + index - is +1, pe, inorder, index + 1, ie);

        return treeNode;
    }
}
