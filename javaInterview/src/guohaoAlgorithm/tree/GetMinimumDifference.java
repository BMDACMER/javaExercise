package guohaoAlgorithm.tree;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 23:11
 *
 * 530. 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {

    // 效率有点低
    public int getMinimumDifference2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traversive(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }

    private void traversive(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        traversive(root.left, list);
        list.add(root.val);
        traversive(root.right, list);
    }

    // 高效算法
    int pre = -1, ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
