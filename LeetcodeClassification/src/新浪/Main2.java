package 新浪;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/13 16:21
 * 1、二叉树转换
 */
public class Main2 {
    /**
     * 按题意转换，并返回转换后的 TreeNode
     * @param node
     * @return
     */
    public static TreeNode transform(TreeNode node) {
        // 该二叉树特点：右节点要么为空，要么一定存在对应的左节点
        // 判断只有一个根节点
        if (node == null || node.left == null || node.right == null)
            return node;
        // 至少两个节点，且右节点要么为空，要么一定存在对应的左节点
        //1 找到最左边的叶子节点，将其设为根
        TreeNode root = null, temp = node;
        TreeNode tempLeft = null, tempRoot = null;
        while (temp.left != null) {
            tempRoot = temp;
            tempLeft = temp.left;
            temp = temp.left;
        }
        root = tempLeft;
        root.left = tempRoot.right;
        root.right = tempRoot;

        // 2 上面是一轮循环，一直遍历直到为空即可
        // 这时候的根节点为root.right
        transform(root.right);

        return root;
    }

    /**
     * 遍历
     */
    public static void print(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
    }
}


