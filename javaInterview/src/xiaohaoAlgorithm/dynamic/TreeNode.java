package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/17 18:24
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
