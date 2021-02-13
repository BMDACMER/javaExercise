package guohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author guohao
 * @Date 2021/2/13 10:28
 * @Version 1.0
 *
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class FindDisappearedNumbers {

    // 时间复杂度和空间复杂度均为 O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[n + 1];
        arr[0] = 1;  // 抛出0这个元素
        for (int i = 0; i < n; i++) {
            arr[nums[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }

    /**
     * 时间复杂度和空间复杂度均为 O(n)
     *
     * 具体来说，遍历 nums，每遇到一个数 x，就让 nums[x?1] 增加 n。
     * 由于 nums 中所有数均在 [1,n] 中，增加以后，这些数必然大于 n。最后我们遍历
     * nums，若 nums[i] 未大于 n，就说明没有遇到过数 i+1。这样我们就找到了缺失的数字。
     *
     * 注意，当我们遍历到某个位置时，其中的数可能已经被增加过，因此需要对 n取模来还原出它本来的值。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> findDisappearedNumbersII(int[] nums) {
        int n = nums.length;
        int x;
        for (int i = 0; i < n; i++) {
            x = (nums[i] - 1) % n;
            nums[x] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }


}
