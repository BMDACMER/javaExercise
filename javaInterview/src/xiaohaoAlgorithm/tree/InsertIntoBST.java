package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 16:57
 *
 * 701. 二叉搜索树中的插入操作
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空闲位置，直接插入新节点
        if (root == null) return new TreeNode(val);
        // 题目要求：输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
        // 如果已经存在，则不需要重复插入了
//        if (root.val == val) return root;   // 这句可以省略
        // val 小则插入左子树
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        // val大则插入右子树
        if (root.val < val) root.right = insertIntoBST(root.right, val);

        return root;
    }
}
