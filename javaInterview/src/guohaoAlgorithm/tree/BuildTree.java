package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 11:17
 *
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // base case
        if (pStart > pEnd || iStart > iEnd) return null;

        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);
        int rootIndex = getIndex(inorder, iStart, iEnd, val);
        int len = rootIndex - iStart;
        root.left = build(preorder, pStart + 1, pStart + len, inorder, iStart, rootIndex - 1);
        root.right = build(preorder, pStart + len + 1, pEnd, inorder, rootIndex + 1, iEnd);
        return root;
    }

    private int getIndex(int[] inorder, int iStart, int iEnd, int val) {
        for (int i = iStart; i <= iEnd; i++) {
            if (val == inorder[i])
                return i;
        }
        return -1;  // 没找到
    }
}
