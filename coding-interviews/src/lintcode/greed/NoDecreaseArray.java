package lintcode.greed;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/27 9:27
 *
 * 其实说的简单点，有2种情况：
 *
 * 升序序列中，突然有个数字小了，则nums[i]=nums[i-1]
 * 升序序列中，突然有个数字大了，则nums[i-1]=nums[i]
 *
 * 作者：gycs
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array/solution/fen-2chong-qing-kuang-by-gycs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NoDecreaseArray {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i -1] <= nums[i]){
                continue;
            }
            count++;//这句代码不要放在条件判断的内部，一定要确保只要不满足非递减就必须执行这句代码
            if(i - 2 >= 0 && nums[i-2] > nums[i]){//这种情况是突然遇到了一个比前一个数小的数字，同时小于它前一个的前一个数字
                nums[i] = nums[i - 1];//这句代码是更新第i个位置的数据，保证其非递减行，但不要担心，因为在这之前，计数器已经+1了
            }
            else{//这种情况是突然遇到了一个比前一个数小的数字，但是大于它前一个的前一个数字
                nums[i-1] = nums[i];//这句代码是更新第i个位置的数据，保证其非递减行，但不要担心，因为在这之前，计数器已经+1了
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        NoDecreaseArray noDecreaseArray = new NoDecreaseArray();
        int[] nums = {4,3,2,3};
        System.out.println(noDecreaseArray.checkPossibility(nums));;
    }
}
