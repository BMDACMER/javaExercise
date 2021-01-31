package guohaoAlgorithm.backtrack;

import guohaoAlgorithm.list.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/30 17:32
 *
 * 78. �Ӽ�
 * ����һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3]
 * �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * ʾ�� 2��
 *
 * ���룺nums = [0]
 * �����[[],[0]]
 */
public class Subsets {

    // �Ӽ�����Ϻ���
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;

        LinkedList<Integer> path = new LinkedList<>();
        backtrace(nums, path, 0);
        return res;
    }

    private void backtrace(int[] nums, LinkedList<Integer> path, int index) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums, path, index + 1);
            path.removeLast();
        }
    }
}
