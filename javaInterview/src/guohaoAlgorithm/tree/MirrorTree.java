package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 16:49
 *
 * ½£Ö¸ Offer 27. ¶þ²æÊ÷µÄ¾µÏñ
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode treeNode = mirrorTree(root.left);
            root.left = mirrorTree(root.right);
            root.right = treeNode;
            return root;
        } else return null;
    }
}
