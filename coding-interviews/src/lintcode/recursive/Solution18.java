package lintcode.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 11:25
 *
 * 145. 二叉树的后序遍历
 */
public class Solution18 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if (root == null) return ret;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            ret.add(t.val);
            if (t.left != null) stack.push(t.left);
            if (t.right != null) stack.push(t.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
