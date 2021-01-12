package guohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 15:54
 *
 * 99. �ָ����������� hard
 */
public class RecoverTree {

    /*TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        traverse(root.right);
    }
    */

    // ��������
    /**
     * �ο���https://leetcode-cn.com/problems/recover-binary-search-tree/solution/er-cha-shu-zhi-hui-fu-er-sou-suo-shu-cow-by-a-fei-/
     * ���������ǲ��ѷ��֣���չ�������飬���Ƿ��֣��󲿷����ڵ����������ϸ�����ģ�Ψ�������η����˵ݼ�������ͼ��ʾ��[7,4][7,4]��[6,3][6,3],����Ҫ�ҵ�
     * firstfirst �ڵ��ǵ�һ�η����½�����ĵ�һ���ڵ�
     * secondsecond �ڵ��ǵڶ��η����½�����ĵڶ����ڵ�
     * ��Ϊsecondsecond�ڵ���Ҫ�����ǣ������ҵ��ڶ��ν��и���
     */

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    TreeNode pre = null, first = null, second = null;
    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) first = pre;
            second = root;
        }
        pre = root;
        traverse(root.right);
    }
}
