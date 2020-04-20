import sun.reflect.generics.tree.Tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
        // 空结点或者只有一个结点 则返回空
        if (pNode == null)
            return pNode;
        if (pNode.right != null) { // 节点有右子树
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode.next != null && pNode.next.left == pNode) { // 节点无右子树且该节点为父节点的左子节点
            return pNode.next;
        } else if (pNode.next != null && pNode.next.right == pNode) { // 节点无右子树且该节点为父节点的右子节点
            while (pNode.next != null && pNode.next.left != pNode) {
                pNode = pNode.next;
            }
            return pNode.next;
        } else {
            return pNode.next;//节点无父节点 ，即节点为根节点
        }
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        // 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) node = node.left;
            return node;
        } else {
            // 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }
}

