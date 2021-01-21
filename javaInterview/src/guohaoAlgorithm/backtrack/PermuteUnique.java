package guohaoAlgorithm.backtrack;

import java.net.InetAddress;
import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 11:17
 *
 * 47. ȫ���� II   �������㷨��
 *
 * ����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ����
 */
public class PermuteUnique {

   /* // ��46��һ��  ֻ�ǽ���ͬ������ȥ��-----    Ч�ʺܵ�   ����9.71%
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        Set<List<Integer>> set = new HashSet<>();
        *//**
         * path ---- ·��
         * depth --- ���   Ĭ��Ϊ0   Ҳ��һ��Ԫ�ض���ȡ
         * Set -- ��Ž������ȥ�صģ�
         * used -- ���Ա���Ƿ���ʸ�Ԫ��
         *//*
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        int depth = 0;
        dfs(nums, len, depth, path, used, set);

        for (List<Integer> list : set) {
            res.add(list);
        }
        return res;
    }

    private void dfs(int[] nums, int len, int depth, LinkedList<Integer> path, boolean[] used, Set<List<Integer>> set) {
        if (len == depth) {
            set.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, set);
            path.removeLast();
            used[i] = false;
        }
    }*/


    // ��������  ��ЧһЩ
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        Arrays.sort(nums);  // Ϊ��ȥ��
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        int depth = 0;
        dfs(nums, len, depth, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, LinkedList<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }

    }

}
