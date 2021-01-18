package guohaoAlgorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 22:05
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        List<String> res = new ArrayList<>();
        constructPath(root, "", res);
        return res;
    }

    private void constructPath(TreeNode root, String path, List<String> res) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                res.add(sb.toString());
            } else {
                sb.append("->");
                constructPath(root.left, sb.toString(), res);
                constructPath(root.right, sb.toString(), res);
            }
        }
    }
}
