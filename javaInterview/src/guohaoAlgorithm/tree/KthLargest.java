package guohaoAlgorithm.tree;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 17:46
 *
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class KthLargest {

    // 效率低
    /*ArrayList<Integer> list;
    public int kthLargest(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        return list.get(list.size() - k);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }*/

    // 递归 效率高
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}
