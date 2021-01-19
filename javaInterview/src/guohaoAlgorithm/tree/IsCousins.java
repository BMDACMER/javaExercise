package guohaoAlgorithm.tree;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 15:45
 *
 * 993. �����������ֵܽڵ�
 */
public class IsCousins {

    /**
     * �㷨˼�룺���ֵܾ��� ���ڵ㲻ͬ�����ڲ�����ͬ  ���Զ�������hashmap �ֱ�洢 ��ǰ�ڵ�ĸ��ڵ�����ڲ���
     */
    HashMap<Integer, TreeNode> parent = new HashMap<>();
    HashMap<Integer, Integer> depth = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        return (depth.get(x) == depth.get(y)) && (parent.get(x) != parent.get(y));
    }

    private void dfs(TreeNode root, TreeNode father) {
        if (root != null) {
            // ������ȷ˵���� �����ڵ�λ����� 0 ��
            depth.put(root.val, father != null ? 1 + depth.get(father.val) : 0);
            parent.put(root.val, father);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
