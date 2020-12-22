package xiaohaoAlgorithm.oneQuestionPerDay;


import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/22 17:56
 * 103. 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {
    /**
     * 层序遍历的改装即可   设置就交替就行
     * level = 奇数 从左边遍历
     * level = 偶数  从右边遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();

        int level = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    // 偶数行 从右往左
                    list.add(0, node.val);
                } else {
                    // 奇数行从左往右
                    list.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            level++;
            lists.add(list);
        }

        return lists;
    }

    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        if ((level & 1) == 1){
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }

        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }
*/
}
