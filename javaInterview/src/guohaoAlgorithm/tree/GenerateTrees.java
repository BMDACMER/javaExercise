package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 20:42
 *
 * 95. 不同的二叉搜索树 II
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low >= high) {
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> left = build(low, i - 1);
            List<TreeNode> right = build(i + 1, high);

            for(TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }

        }
        return res;
    }
}
