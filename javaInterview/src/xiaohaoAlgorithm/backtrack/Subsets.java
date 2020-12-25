package xiaohaoAlgorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/25 10:14
 *
 * 78. ×Ó¼¯
 */
public class Subsets {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> arrayList = new ArrayList<>();
        backtrack(nums, 0, arrayList);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> arrayList) {
        result.add(new ArrayList<>(arrayList));

        for (int i = start; i < nums.length; i++) {
            arrayList.add(nums[i]);
            backtrack(nums, i + 1, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = {1,2,3};
        s.subsets(nums);
    }
}
