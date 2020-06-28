package lintcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
// 层序遍历
public class Test52 {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            arrayList.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            queue.poll();
        }
        return arrayList;
    }
}
