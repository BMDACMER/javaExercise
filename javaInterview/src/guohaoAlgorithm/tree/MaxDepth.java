package guohaoAlgorithm.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 10:58
 *
 * 559. N 叉树的最大深度
 */
public class MaxDepth {

    // 参考：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/solution/ncha-shu-de-zui-da-shen-du-by-leetcode/
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 1;
        for (Node node : root.children){
            max = Math.max(max, maxDepth(node) + 1);
        }
        return max;
    }

    public int maxDepth2(Node root) {
        if (root == null) return 0;
        if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> list = new LinkedList<>();
            for (Node child : root.children) {
                list.add(maxDepth2(child) + 1);
            }
            return Collections.max(list);
        }
    }
}
