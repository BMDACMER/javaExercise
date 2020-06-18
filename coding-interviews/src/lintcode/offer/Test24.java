package lintcode.offer;

public class Test24 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 右孩子不为空 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
        if (pNode.right != null) {
            TreeLinkNode node = pNode.next;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // 否则，向上找第一个左链接指向的树包含该节点的祖先节点
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
