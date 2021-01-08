package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 13:11
 * <p>
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree2 {
    /**
     * 通过中序后序构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) return null;

        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = getIndex(inorder, iStart, iEnd, rootVal);
        int intervalLen = rootIndex - iStart;
        root.left = build(inorder, iStart, rootIndex - 1, postorder, pStart, pStart + intervalLen - 1);
        root.right = build(inorder, rootIndex + 1, iEnd,postorder, pStart + intervalLen, pEnd - 1);
        return root;
    }

    private int getIndex(int[] inorder, int iStart, int iEnd, int rootVal) {
        for (int i = iStart; i <= iEnd; i++) {
            if (rootVal == inorder[i])
                return i;
        }
        return -1;
    }
}
