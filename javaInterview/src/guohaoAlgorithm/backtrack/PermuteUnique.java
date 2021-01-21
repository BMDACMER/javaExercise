package guohaoAlgorithm.backtrack;

import java.net.InetAddress;
import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 11:17
 *
 * 47. 全排列 II   （回溯算法）
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 */
public class PermuteUnique {

   /* // 与46题一样  只是将相同的排列去重-----    效率很低   击败9.71%
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        Set<List<Integer>> set = new HashSet<>();
        *//**
         * path ---- 路径
         * depth --- 深度   默认为0   也即一个元素都不取
         * Set -- 存放结果集（去重的）
         * used -- 用以标记是否访问该元素
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


    // 方法二：  高效一些
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        Arrays.sort(nums);  // 为了去重
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
