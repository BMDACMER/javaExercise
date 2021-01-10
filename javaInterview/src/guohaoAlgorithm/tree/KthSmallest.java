package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 15:00
 *
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {

    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;

        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
        }
       kthSmallest(root.right, k);

        return ans;
    }
}
