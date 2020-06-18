package lintcode.offer;

public class Test24 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // �Һ��Ӳ�Ϊ�� ���һ���ڵ����������Ϊ�գ���ô�ýڵ����һ���ڵ���������������ڵ㣻
        if (pNode.right != null) {
            TreeLinkNode node = pNode.next;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // ���������ҵ�һ��������ָ����������ýڵ�����Ƚڵ�
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}
