package lintcode.sort;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/9 10:30
 * <p>
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共?n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、?1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColor {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;  // 跳出条件
        int i = start;
        int j = end;
        if (i < j) {
            int tmp = nums[i];
            while (i < j) {
                while (i < j && nums[j] >= tmp) j--;
                nums[i] = nums[j];
                while (i < j && nums[i] <= tmp) i++;
                nums[j] = nums[i];
            }
            nums[i] = tmp;
        }
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }
}
