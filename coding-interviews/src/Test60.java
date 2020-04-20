import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Test60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
       ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
       Queue<TreeNode> queue = new LinkedList<>();
       boolean reverse = false;
       queue.add(pRoot);
       while (!queue.isEmpty()) {
           ArrayList<Integer> list = new ArrayList<>();
           int count = queue.size();
           while (count-- > 0) {
               TreeNode node = queue.poll();
               if (node == null) {
                   continue;
               }
               list.add(node.val);
               queue.add(node.left);
               queue.add(node.right);
           }

           if (reverse)
               Collections.reverse(list);
           reverse = !reverse;
           if (list.size() != 0)
               ret.add(list);
       }
       return ret;
    }

}
