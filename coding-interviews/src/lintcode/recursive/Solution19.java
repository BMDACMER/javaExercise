package lintcode.recursive;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 11:40
 */
public class Solution19 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ret;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 一直寻找左节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
}
