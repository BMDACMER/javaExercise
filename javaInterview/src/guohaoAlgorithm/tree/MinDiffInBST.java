package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 11:46
 *
 * 783. 二叉搜索树节点最小距离
 */
public class MinDiffInBST {

    // 思路：中序遍历保存BST的结果   然后遍历数组相邻元素求最小值
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
