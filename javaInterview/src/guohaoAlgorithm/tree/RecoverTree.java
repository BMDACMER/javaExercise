package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 15:54
 *
 * 99. 恢复二叉搜索树 hard
 */
public class RecoverTree {

    /*TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        traverse(root.right);
    }
    */

    // 方法二：
    /**
     * 参考：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/er-cha-shu-zhi-hui-fu-er-sou-suo-shu-cow-by-a-fei-/
     * 分析后我们不难发现，当展开的数组，我们发现，大部分相邻的两个数是严格递增的，唯独有两段发送了递减，如上图所示的[7,4][7,4]与[6,3][6,3],我们要找的
     * firstfirst 节点是第一段发生下降区域的第一个节点
     * secondsecond 节点是第二段发生下降区域的第二个节点
     * 因为secondsecond节点需要被覆盖，我们找到第二段进行覆盖
     */

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    TreeNode pre = null, first = null, second = null;
    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) first = pre;
            second = root;
        }
        pre = root;
        traverse(root.right);
    }
}
