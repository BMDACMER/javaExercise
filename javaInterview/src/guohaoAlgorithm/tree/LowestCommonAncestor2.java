package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 19:52
 * <p>
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor2 {

    // bst 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    // 非递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> rootP = getPath(root, p);
        List<TreeNode> rootQ = getPath(root, q);
        TreeNode ans = null;

        for (int i = 0; i < rootP.size() && i < rootQ.size(); i++) {
            if (rootP.get(i) == rootQ.get(i)) {
                ans = rootP.get(i);
            } else break;
        }
        return ans;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else if (target.val > node.val) {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
