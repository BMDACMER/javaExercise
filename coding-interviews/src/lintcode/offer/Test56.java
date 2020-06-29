package lintcode.offer;

import java.util.ArrayList;

// 34. 二叉树中和为某一值的路径
public class Test56 {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return lists;
        arrayList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            lists.add(new ArrayList<>(arrayList));
        FindPath(root.left, target);
        FindPath(root.right, target);
        arrayList.remove(arrayList.size() - 1);
        return lists;
    }
}
