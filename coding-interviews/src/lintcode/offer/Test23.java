package lintcode.offer;

import java.util.HashMap;

/**
 * 重建二叉树
 * 根据左子树和右子树来重建二叉树
 */
public class Test23 {
    // 用hashmap存储中序遍历的各结点的索引
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        // 将中序遍历的值放入道map中
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return  reConstructBinaryTree(pre,0,pre.length-1,0);
    }

    // 构建多态函数  根据前序遍历将中序遍历分为左右两部分
    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd)
            return null;  // 遍历完毕
        // 通过左子树寻找中序遍历中的根节点
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndex = map.get(root.val);
        int leftSize = rootIndex - inStart;
        // 根据找到的左子树大小，来递归调用该函数
        root.left = reConstructBinaryTree(pre,preStart+1,preStart+leftSize,inStart);
        // 根据找到的右子树大小，来递归调用该函数
        root.right = reConstructBinaryTree(pre,preStart+leftSize+1,preEnd,inStart+leftSize+1);
        return root;
    }
}


