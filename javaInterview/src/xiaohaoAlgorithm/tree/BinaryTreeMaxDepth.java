package xiaohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/8 13:29
 */
public class BinaryTreeMaxDepth {

    // �ݹ�д�� DFS
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // �ǵݹ�д��DFS

    /**
     * ��������ջ��ʵ��
     *https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/di-gui-bfsdfsde-3chong-jie-jue-fang-shi-by-sdwwld/
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        int maxDepth = 0;
        stack.push(root);
        level.push(1);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer temp = level.pop();
            maxDepth = Math.max(maxDepth, temp);

            if (node.right != null) {
                stack.push(node.right);
                level.push(temp + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                level.push(temp + 1);
            }

        }
        return maxDepth;
    }

    /**
     * BFS �ǵݹ�
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();   // �������ݽṹ
        queue.offer(root);  // ����������������£�add() �������׳�IllegalStateException�쳣��offer() ����ֻ�᷵�� false ��
        int step = 1;  // root�������һ�㣬��depth��ʼ��Ϊ1  �����¼��ɢ�Ĳ���

        while (!queue.isEmpty()) {
            int len = queue.size();
            // ����ǰ�����е����нڵ���������ɢ
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                /*// �ж��Ƿ�ﵽ�յ�
                if (cur.left == null && cur.right == null)
                    return step;*/
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            step++; // ���²���
        }
        return step;
    }
}
