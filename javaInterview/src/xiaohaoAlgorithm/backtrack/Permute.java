package xiaohaoAlgorithm.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/7 12:46
 * 46. 全排列
 */
public class Permute {

    static List<List<Integer>> ans = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return ans;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 满足条件
        if (track.size() == nums.length) {
            ans.add(new LinkedList<>(track));
            return;
        }

        // 在列表中选择
        for (int i = 0; i < nums.length; i++) {
            // 排除不合适的
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> lists = permute(nums);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
