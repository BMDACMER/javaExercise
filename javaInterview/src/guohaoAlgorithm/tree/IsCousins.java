package guohaoAlgorithm.tree;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 15:45
 *
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {

    /**
     * 算法思想：堂兄弟就是 父节点不同但所在层数相同  所以定义两个hashmap 分别存储 当前节点的父节点和所在层数
     */
    HashMap<Integer, TreeNode> parent = new HashMap<>();
    HashMap<Integer, Integer> depth = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        return (depth.get(x) == depth.get(y)) && (parent.get(x) != parent.get(y));
    }

    private void dfs(TreeNode root, TreeNode father) {
        if (root != null) {
            // 题意明确说明： ，根节点位于深度 0 处
            depth.put(root.val, father != null ? 1 + depth.get(father.val) : 0);
            parent.put(root.val, father);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
