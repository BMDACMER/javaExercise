package xiaohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/8 11:17
 * 111. ����������С���
 */
public class BinaryTreeMinDepth {

    /**
     * BFS ���
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();   // �������ݽṹ
        queue.offer(root);  // ����������������£�add() �������׳�IllegalStateException�쳣��offer() ����ֻ�᷵�� false ��
        int step = 1;  // root��������ײ㣬��depth��ʼ��Ϊ1  �����¼��ɢ�Ĳ���

        while (!queue.isEmpty()) {
            int len = queue.size();
            // ����ǰ�����е����нڵ���������ɢ
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                // �ж��Ƿ�ﵽ�յ�
                if (cur.left == null && cur.right == null)
                    return step;
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
