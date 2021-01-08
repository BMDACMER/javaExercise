package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 13:59
 *
 * 652. 寻找重复的子树
 */
public class FindDuplicateSubtrees {

    /**
     * 算法思路：找出以当前节点为根节点的子树，接着找以子节点为根节点的子树，序列化各子树，最后比较是否相等
     * 将只出现一次的子树放到结果集中，并返回结果集
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
        // 找出以当前节点为根节点的子树  可以采用后序遍历   左右根
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
