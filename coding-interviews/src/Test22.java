import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
�������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��

˼·���������Ĳ��������BFS��  ��������
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
            arrayList.add(node.val);  // ���뵱ǰ��ֵ
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            q.poll();  // ɾ����ǰ��ֵ
        }
        return arrayList;
    }

}
