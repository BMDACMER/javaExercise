package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 12:05
 *
 * 897. µ›‘ˆÀ≥–Ú≤È’“ ˜
 */
public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode head = new TreeNode(root.val), cur = head;
        for (int node : list) {
            cur.right = new TreeNode(node);
            cur = cur.right;
        }
        return head.right;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)  return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
