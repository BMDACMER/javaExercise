import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

思路：二叉树的层序遍历（BFS）  借助队列
 */
public class Test22 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if (root == null) {
            return null;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.peek();
            arrayList.add(node.val);  // 放入当前的值
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            q.poll();  // 删除当前的值
        }
        return arrayList;
    }

}
