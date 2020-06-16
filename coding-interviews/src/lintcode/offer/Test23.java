package lintcode.offer;

import java.util.HashMap;

/**
 * �ؽ�������
 * ���������������������ؽ�������
 */
public class Test23 {
    // ��hashmap�洢��������ĸ���������
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        // �����������ֵ�����map��
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return  reConstructBinaryTree(pre,0,pre.length-1,0);
    }

    // ������̬����  ����ǰ����������������Ϊ����������
    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd)
            return null;  // �������
        // ͨ��������Ѱ����������еĸ��ڵ�
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndex = map.get(root.val);
        int leftSize = rootIndex - inStart;
        // �����ҵ�����������С�����ݹ���øú���
        root.left = reConstructBinaryTree(pre,preStart+1,preStart+leftSize,inStart);
        // �����ҵ�����������С�����ݹ���øú���
        root.right = reConstructBinaryTree(pre,preStart+leftSize+1,preEnd,inStart+leftSize+1);
        return root;
    }
}


