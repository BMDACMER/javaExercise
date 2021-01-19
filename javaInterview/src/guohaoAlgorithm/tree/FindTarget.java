package guohaoAlgorithm.tree;

import javabase.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 9:51
 *
 * 653. 两数之和 IV - 输入 BST
 */
public class FindTarget {

    ArrayList<Integer> list = new ArrayList<>();
    public boolean findTarget2(TreeNode root, int k) {
        traverse(root);
        for (int i = 0; i < list.size(); i++) {
            int res = k - list.get(i);
            int left = i + 1, right = list.size(), mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (list.get(mid) == res) return true;
                else if (list.get(mid) > res) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }


    /// 高效算法
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;

        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
