import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 */
public class Test39 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    // 递归
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    // 层序遍历
    public int getTreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 0, depth = 0, nextCount = 1;
        while (queue.size() > 0) {
            count++;   // 相当于root这一层
            TreeNode p = queue.poll();  // 父节点出队
            if (p.left != null) {
                queue.add(p.left);
            } else if (p.right != null) {
                queue.add(p.right);
            }
            if (count == nextCount) {
                depth++;
                count = 0;
                nextCount = queue.size();
            }

        }
        return depth;
    }

}
