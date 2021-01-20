package guohaoAlgorithm.array;

import javabase.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/20 19:41
 *
 * 46. ȫ����
 */
public class Permute {

    // ����������ȱ���dfs
    /**
     *  ˼·�������ڶ���������һ��Ϊ������[]  �ڶ���ֱ���1 2 3 ...Ԫ�����  ֮������㡣����ֱ��������Ҷ�ӽڵ�
     *  ����һ��depth=0   �����һ�㼴Ϊ���鳤��  ������ֹ����  ֮����ǻ�����
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0)  return res;
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, LinkedList<Integer> path, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
