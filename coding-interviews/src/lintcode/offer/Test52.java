package lintcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
// �������
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
