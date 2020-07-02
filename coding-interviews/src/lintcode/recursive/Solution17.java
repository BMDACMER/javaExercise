package lintcode.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 10:57
 */
public class Solution17 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t == null) continue;
            ret.add(t.val);
            if (t.right != null) stack.add(t.right);
            if (t.left != null) stack.add(t.left);
        }
        return ret;
    }
}
