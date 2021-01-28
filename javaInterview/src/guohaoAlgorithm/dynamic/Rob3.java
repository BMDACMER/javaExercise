package guohaoAlgorithm.dynamic;

import guohaoAlgorithm.tree.TreeNode;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 9:52
 *
 * 337. ��ҽ��� III
 * ���ϴδ����һ���ֵ�֮���һȦ���ݺ�С͵�ַ�����һ���µĿ����Եĵ������������ֻ��һ����ڣ����ǳ�֮Ϊ�������� ���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö��������� �������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������
 *
 * �����ڲ���������������£�С͵һ���ܹ���ȡ����߽�
 *
 * ʾ�� 1:
 *
 * ����: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * ���: 7
 * ����: С͵һ���ܹ���ȡ����߽�� = 3 + 3 + 1 = 7.
 */
public class Rob3 {
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;

        if (memo.containsKey(root)) return memo.get(root);

        int do_it = root.val + ((root.left == null) ? 0 : rob(root.left.left) + rob(root.left.right))
                + ((root.right == null) ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_do = rob(root.left) + rob(root.right);
        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}
