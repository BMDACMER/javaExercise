package lintcode.offer;

/**
 * 面试题07. 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
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
        // 处理异常点
        if (ps > pe || is > ie) {
            return null;
        }

        // 前序遍历第一个节点为根节点
        int root = preorder[ps];
        int index = is;   // 在中序遍历中寻找根节点
        while (index <= ie) {
            if (inorder[index] == root) {
                break;  // 找到根节点
            }
            index++;
        }

        if (index > ie) {
            throw new RuntimeException("输入不合法");
        }
sta
        // 到达这一步表示已经找到根节点   将原来的树一分为二
        TreeNode treeNode = new TreeNode(root);

        // 左子树对应的前序遍历的位置在[ps+1, ps+index-ins]
        // 左子树对应的中序遍历的位置在[ins, index-1]
        treeNode.left = rebuildTree(preorder, ps+1, ps + index - is, inorder, is, index - 1);

        // 右子树对应的前序遍历的位置在[ps + index - ins +1, pe]
        // 右子树对应的中序遍历的位置在[index + 1, ine]
        treeNode.right = rebuildTree(preorder, ps + index - is +1, pe, inorder, index + 1, ie);

        return treeNode;
    }
}
