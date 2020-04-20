import sun.reflect.generics.tree.Tree;

/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */
public class Test58 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // �ս�����ֻ��һ����� �򷵻ؿ�
        if (pNode == null)
            return pNode;
        if (pNode.right != null) { // �ڵ���������
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode.next != null && pNode.next.left == pNode) { // �ڵ����������Ҹýڵ�Ϊ���ڵ�����ӽڵ�
            return pNode.next;
        } else if (pNode.next != null && pNode.next.right == pNode) { // �ڵ����������Ҹýڵ�Ϊ���ڵ�����ӽڵ�
            while (pNode.next != null && pNode.next.left != pNode) {
                pNode = pNode.next;
            }
            return pNode.next;
        } else {
            return pNode.next;//�ڵ��޸��ڵ� �����ڵ�Ϊ���ڵ�
        }
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        // ���һ���ڵ����������Ϊ�գ���ô�ýڵ����һ���ڵ���������������ڵ㣻
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) node = node.left;
            return node;
        } else {
            // ���������ҵ�һ��������ָ����������ýڵ�����Ƚڵ㡣
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }
}

