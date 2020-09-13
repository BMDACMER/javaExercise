package ����;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/13 16:21
 * 1��������ת��
 */
public class Main2 {
    /**
     * ������ת����������ת����� TreeNode
     * @param node
     * @return
     */
    public static TreeNode transform(TreeNode node) {
        // �ö������ص㣺�ҽڵ�ҪôΪ�գ�Ҫôһ�����ڶ�Ӧ����ڵ�
        // �ж�ֻ��һ�����ڵ�
        if (node == null || node.left == null || node.right == null)
            return node;
        // ���������ڵ㣬���ҽڵ�ҪôΪ�գ�Ҫôһ�����ڶ�Ӧ����ڵ�
        //1 �ҵ�����ߵ�Ҷ�ӽڵ㣬������Ϊ��
        TreeNode root = null, temp = node;
        TreeNode tempLeft = null, tempRoot = null;
        while (temp.left != null) {
            tempRoot = temp;
            tempLeft = temp.left;
            temp = temp.left;
        }
        root = tempLeft;
        root.left = tempRoot.right;
        root.right = tempRoot;

        // 2 ������һ��ѭ����һֱ����ֱ��Ϊ�ռ���
        // ��ʱ��ĸ��ڵ�Ϊroot.right
        transform(root.right);

        return root;
    }

    /**
     * ����
     */
    public static void print(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
    }
}


