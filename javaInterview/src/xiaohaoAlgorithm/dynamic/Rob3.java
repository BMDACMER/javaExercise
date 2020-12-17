package xiaohaoAlgorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/17 18:14
 * 337. 打家劫舍 III
 */
public class Rob3 {

    // 备忘录，记录在某个节点上的最优选择
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root)) return memo.get(root);

        // 取， 然后去下家做选择
        int get_it = root.val + (root.left == null ? 0 : rob(root.left.left )+ rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不取， 然后去下家做选择
        int notGet = (root.left == null ? 0 : rob(root.left)) + (root.right == null ? 0 : rob(root.right));
        // 选择收益最大的
        int res = Math.max(get_it, notGet);
        memo.put(root, res);
        return res;
    }
}
