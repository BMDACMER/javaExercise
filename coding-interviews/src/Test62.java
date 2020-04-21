import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 *
 *请实现两个函数，分别用来序列化和反序列化二叉树

 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二
 叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 */
public class Test62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public String Serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 1; // 用来记录当前节点及其后面非空节点的个数
        while (!queue.isEmpty() && root != null) {
            TreeNode node = queue.poll();
            if (node == null) {
                ans.append("#");
            } else {
                ans.append(node.val);
                sum--;
                if (node.left != null) {
                    sum++;
                }
                if (node.right != null) {
                    sum++;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (sum != 0) {
                ans.append(",");
            } else {
                break;
            }
        }
        ans.append("]");
        return ans.toString();
    }
    public TreeNode Deserialize(String str) {
        String s = str.substring(1,str.length() - 1);  // 去除 【 】
        if ("".equals(s)) {
            return null;   // str=[]
        }
        String[] a = s.split(",");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode root = new TreeNode(change(a[index++]));
        TreeNode root = new TreeNode(Integer.parseInt(a[index++]));
        queue.add(root);
        while (!queue.isEmpty() && index < a.length) {
            TreeNode node = queue.poll();
            if (!"#".equals(a[index])) {
                node.left = new TreeNode(Integer.parseInt(a[index++]));
                queue.add(node.left);
            } else {
                index++;
            }
            if (index < a.length && !"#".equals(a[index])) {
                node.right = new TreeNode(Integer.parseInt(a[index++]));
                queue.add(node.right);
            } else {
                index++;
            }
        }
        return root;
    }

    private int change(String s) {
        int res = 0;
        int i = 0;
        int flag = 1;
        if (s.charAt(0) == '-') {
            i++;
            flag = -1;
        }
        for (; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res * flag;
    }

}
