package 分治;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:15
 */
public class 多数元素递归 {
    /**
     * 采用分治思想，递归思路。
     * 1、确定切分的终止条件，直到所有的子问题都是长度为 1 的数组，停止切分。
     * 2、拆分数组，递归地将原数组二分为左区间与右区间，直到最终的数组只剩下一个元素，将其返回
     * 3、处理子问题得到子结果，并合并
     *    3.1 长度为 1 的子数组中唯一的数显然是众数，直接返回即可。
     *    3.2 如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。
     *    3.3 如果他们的众数不同，比较两个众数在整个区间内出现的次数来决定该区间的众数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length < 1) return 0;
        return help(nums, 0, nums.length - 1);
    }

    private int help(int[] nums, int start, int end) {
        // 1、拆分数组，直到剩下最后一个 一定为众数
        if (start == end) return nums[start];
        // 2、处理子问题
        int mid = start + (end - start) / 2;
        int left = help(nums,start,mid);
        int right = help(nums, mid+1,end);
        //  如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。
        if (left == right)
            return left;

        // 统计左右区间的众数
        int leftCount = countElement(nums, left, start, end);
        int rightCount = countElement(nums, right, start, end);

       return leftCount > rightCount ? left : right;
    }

    private int countElement(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (num == nums[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        多数元素递归 aa = new 多数元素递归();
        int[] nums = {3,3,3,2,1};
        System.out.println(aa.majorityElement(nums));
    }
}
