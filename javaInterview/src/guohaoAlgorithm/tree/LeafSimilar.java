package guohaoAlgorithm.tree;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 11:54
 *
 * 872. Ò¶×ÓÏàËÆµÄÊ÷
 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inOrderTree(root1, list1);
        inOrderTree(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }else {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i))
                    return false;
            }
            return true;
        }
    }

    private void inOrderTree(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inOrderTree(root.left, list);
        if (root.left == null && root.right == null)
            list.add(root.val);
        inOrderTree(root.right, list);
    }
}
