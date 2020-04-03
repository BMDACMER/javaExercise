
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Test04 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 构建二叉树
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // 异常处理
        if (pre == null || in == null || pre.length != in.length || pre.length < 1) {
            return null;
        }

        return constructBinaryTree(pre, 0 , pre.length-1, in, 0, in.length-1);
    }

    /**
     *
     * @param pre --- 前序遍历
     * @param ps ---- 前序遍历起始点
     * @param pe ---- 前序遍历终止点
     * @param in ---- 中序遍历
     * @param ins ---- 中序遍历起始点
     * @param ine ---- 中序遍历终止点
     * @return ---- 重建树
     */
    private static TreeNode constructBinaryTree(int[] pre, int ps, int pe, int[] in, int ins, int ine) {
        // 处理异常点
        if (ps > pe || ins > ine) {
            return null;
        }

        // 前序遍历第一个节点为根节点
        int root = pre[ps];
        int index = ins;   // 在中序遍历中寻找根节点
        while (index <= ine) {
            if (in[index] == root) {
                break;  // 找到根节点
            }
            index++;
        }

        if (index > ine) {
            throw new RuntimeException("输入不合法");
        }

        // 到达这一步表示已经找到根节点   将原来的树一分为二
        TreeNode treeNode = new TreeNode(root);

        // 左子树对应的前序遍历的位置在[ps+1, ps+index-ins]
        // 左子树对应的中序遍历的位置在[ins, index-1]
        treeNode.left = constructBinaryTree(pre, ps+1, ps + index - ins, in, ins, index - 1);

        // 右子树对应的前序遍历的位置在[ps + index - ins +1, pe]
        // 右子树对应的中序遍历的位置在[index + 1, ine]
        treeNode.right = constructBinaryTree(pre, ps + index - ins +1, pe, in, index + 1, ine);

        return treeNode;
    }

    // 中序遍历二叉树
    public static void printBinaryTree(TreeNode treeNode){
        if (treeNode != null) {
            printBinaryTree(treeNode.left);
            System.out.print(treeNode.val + " ");
            printBinaryTree(treeNode.right);
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        printBinaryTree(root);
    }
}
