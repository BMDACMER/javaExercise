package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 17:24
 * 222. 完全二叉树的节点个数
 */
public class CountNodes {

    /**
     * 效率低下的 通用遍历解法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 完全二叉树一定可以拆分为 至少包含一个满二叉树
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root, r = root;
        // 记录左右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树的高度相同，说明是一棵满二叉树
        if (hl == hr)
            return (int)Math.pow(2, hl) - 1;
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

}
