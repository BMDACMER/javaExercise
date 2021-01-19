package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 9:31
 *
 * 563. ¶þ²æÊ÷µÄÆÂ¶È
 */
public class FindTilt {

    int ans = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return ans;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        ans += Math.abs(left - right);
        return root.val + left + right;
    }
}
