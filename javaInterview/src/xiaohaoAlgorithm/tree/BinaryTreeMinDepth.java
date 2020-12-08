package xiaohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/8 11:17
 * 111. 二叉树的最小深度
 */
public class BinaryTreeMinDepth {

    /**
     * BFS 框架
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();   // 核心数据结构
        queue.offer(root);  // 在容量已满的情况下，add() 方法会抛出IllegalStateException异常，offer() 方法只会返回 false 。
        int step = 1;  // root本身就是易层，将depth初始化为1  负责记录扩散的步数

        while (!queue.isEmpty()) {
            int len = queue.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                // 判断是否达到终点
                if (cur.left == null && cur.right == null)
                    return step;
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
