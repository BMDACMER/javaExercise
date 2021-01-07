package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 15:34
 *
 * 94. ���������������
 */
public class InorderTraversal {

    /**
     * ����1�� �ݹ�
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        inorderTraversal(root.left);
        if (root.left == null && root.right == null)
            list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }

    /**
     * ���������ǵݹ�
     *
     * ����ջ
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            curr = pop.right;
        }
        return list;
    }
}
