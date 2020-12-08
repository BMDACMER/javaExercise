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

    // 递归写法 DFS
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 非递归写法DFS

    /**
     * 借助两个栈来实现
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
     * BFS 非递归
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();   // 核心数据结构
        queue.offer(root);  // 在容量已满的情况下，add() 方法会抛出IllegalStateException异常，offer() 方法只会返回 false 。
        int step = 1;  // root本身就是一层，将depth初始化为1  负责记录扩散的步数

        while (!queue.isEmpty()) {
            int len = queue.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                /*// 判断是否达到终点
                if (cur.left == null && cur.right == null)
                    return step;*/
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            step++; // 更新步数
        }
        return step;
    }
}
