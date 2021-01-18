package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 21:37
 *
 * 235. �����������������������
 */
public class LowestCommonAncestor {

    // �ݹ�
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor1(root.right, p,q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor1(root.left,p,q);
        return root;
    }

    // UnRecursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * �ֱ�� ������������������  Ѱ��p��q��·��   Ȼ��Ƚ�p��q��һ����ͬ��Ԫ�ؼ���
         */
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode ancestor = null;

        for (int i = 0; i < pPath.size()  && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                ancestor = pPath.get(i);
            } else break;
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else if (target.val > node.val) {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }


}
