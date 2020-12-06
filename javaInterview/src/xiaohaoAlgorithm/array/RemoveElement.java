package xiaohaoAlgorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/6 10:38
 *
 * ÌâÄ¿27£ºÒÆ³ıÔªËØ
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int len = nums.length;
        /*while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            }else {
                i++;
            }
        }

        return len;*/

        for (int j = 0; j < len; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,2,1};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
