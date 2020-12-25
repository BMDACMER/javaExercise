package xiaohaoAlgorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/25 10:59
 *
 * 46. È«ÅÅÁĞ
 */
public class Permute2 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
         if (nums.length < 1 || nums == null) return result;
         List<Integer> list = new ArrayList<>();
         backtrack(nums, list);
         return result;
    }

    private void backtrack(int[] nums, List<Integer> list) {
        if (nums.length == list.size())
            result.add(new ArrayList<>(list));

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            backtrack(nums,list);
            list.remove(list.size() - 1);
        }
    }
}
