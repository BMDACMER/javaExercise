package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 13:59
 *
 * 652. Ѱ���ظ�������
 */
public class FindDuplicateSubtrees {

    /**
     * �㷨˼·���ҳ��Ե�ǰ�ڵ�Ϊ���ڵ�����������������ӽڵ�Ϊ���ڵ�����������л������������Ƚ��Ƿ����
     * ��ֻ����һ�ε������ŵ�������У������ؽ����
     * @param root
     * @return
     */
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findSubtrees(root);
        return res;
    }

    HashMap<String, Integer> map = new HashMap<>();
    private String findSubtrees(TreeNode root) {
        // �ҳ��Ե�ǰ�ڵ�Ϊ���ڵ������  ���Բ��ú������   ���Ҹ�
        if (root == null) return "#";

        String left = findSubtrees(root.left);
        String right = findSubtrees(root.right);
        String subTree = left + "," + right + "," + root.val;

        int frequence = map.getOrDefault(subTree, 0);
        if (frequence == 1) {
            res.add(root);
        }
        map.put(subTree, frequence + 1);
        return subTree;
    }
}
