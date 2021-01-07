package guohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 18:07
 *
 * 116. ���ÿ���ڵ����һ���Ҳ�ڵ�ָ��
 */
public class Connect {

    // �ο��� https://labuladong.github.io/algo/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%B3%BB%E5%88%971.html
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    // ��������
    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;

        node1.next = node2;

        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right,node2.left);
    }

    /**
     * �����ⷨ��
     *  1��BFS
     *  2���Ż����BFS
     *  3��BFS����
     *
     */
    // ������BFS
    public Node connect2(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // ÿһ�������
            int levelCount = q.size();
            // ǰһ���ڵ�
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                Node node = q.poll();
                if (pre != null)
                    pre.next = node;
                pre = node;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

        }
        return root;
    }

}
