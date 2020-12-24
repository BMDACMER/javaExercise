package xiaohaoAlgorithm.greedy;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/24 8:50
 *
 * 135. 分发糖果
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int n = ratings.length;
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i-1] + 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i+1])
                right[i] = right[i+1] + 1;
        }

        for (int i = 0; i < n; i++) {
            res += Math.max(left[i], right[i]);
        }

        return res;
    }

    /*public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int[] nums = new int[ratings.length];//记录每一位孩子得到的糖果数
        nums[0] = 1;
        //先正序遍历，如果后一位比前一位高分，就给比前一位多1的糖果，否则给1
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                nums[i] = nums[i-1] + 1;
            }else {
                nums[i] = 1;
            }
        }
        //在倒叙遍历，如果前一位比后一位高分并且得到的糖果小于或等于后一位，就给前一位孩子比后一位孩子多一个糖果
        for(int i = ratings.length -2 ; i >= 0; i--){
            if(ratings[i] > ratings[i+1] && nums[i] <= nums[i+1]){
                nums[i] = nums[i+1] +1;
            }
        }
        int count = 0;
        for(int i : nums){
            count +=i;
        }
        return count;
    }*/

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] nums = {1,2,87,87,87,2,1};
        int candy = c.candy(nums);
        System.out.println(candy);
    }
}
