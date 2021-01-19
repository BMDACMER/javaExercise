package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 11:38
 *
 * 590. N²æÊ÷µÄºóÐò±éÀú
 */
public class Postorder {

    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if (root.children.isEmpty()) {
            ans.add(root.val);
            return ans;
        } else {
            for (Node child : root.children) {
                dfs(child, ans);
            }
            ans.add(root.val);
            return ans;
        }
    }

    private void dfs(Node child, List<Integer> ans) {
        if (child == null) return;
        for (Node node : child.children) {
            dfs(node, ans);
        }
        ans.add(child.val);
    }
}
