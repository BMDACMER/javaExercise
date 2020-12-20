package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 17:24
 * 222. ��ȫ�������Ľڵ����
 */
public class CountNodes {

    /**
     * Ч�ʵ��µ� ͨ�ñ����ⷨ
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * ��ȫ������һ�����Բ��Ϊ ���ٰ���һ����������
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root, r = root;
        // ��¼���������ĸ߶�
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // ������������ĸ߶���ͬ��˵����һ����������
        if (hl == hr)
            return (int)Math.pow(2, hl) - 1;
        // ������Ҹ߶Ȳ�ͬ��������ͨ���������߼�����
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

}
