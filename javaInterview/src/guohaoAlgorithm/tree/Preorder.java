package guohaoAlgorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 11:25
 *
 * 589. N²æÊ÷µÄÇ°Ðò±éÀú
 */
public class Preorder {

    public List<Integer> preorder(Node root) {
        if (root == null) return new LinkedList<Integer>();
        List<Integer> ans = new LinkedList<>();
        ans.add(root.val);
        for (Node child : root.children) {
            dfs(child, ans);
        }
        return ans;
    }

    private void dfs(Node child, List<Integer> ans) {
        if (child == null) return;
        ans.add(child.val);
        for (Node node : child.children) {
            dfs(node, ans);
        }
    }
}
