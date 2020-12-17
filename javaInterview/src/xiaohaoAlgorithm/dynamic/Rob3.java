package xiaohaoAlgorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/17 18:14
 * 337. ��ҽ��� III
 */
public class Rob3 {

    // ����¼����¼��ĳ���ڵ��ϵ�����ѡ��
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // ���ñ���¼�����ص�������
        if (memo.containsKey(root)) return memo.get(root);

        // ȡ�� Ȼ��ȥ�¼���ѡ��
        int get_it = root.val + (root.left == null ? 0 : rob(root.left.left )+ rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // ��ȡ�� Ȼ��ȥ�¼���ѡ��
        int notGet = (root.left == null ? 0 : rob(root.left)) + (root.right == null ? 0 : rob(root.right));
        // ѡ����������
        int res = Math.max(get_it, notGet);
        memo.put(root, res);
        return res;
    }
}
