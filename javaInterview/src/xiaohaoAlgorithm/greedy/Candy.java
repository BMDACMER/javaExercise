package xiaohaoAlgorithm.greedy;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/24 8:50
 *
 * 135. �ַ��ǹ�
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
        int[] nums = new int[ratings.length];//��¼ÿһλ���ӵõ����ǹ���
        nums[0] = 1;
        //����������������һλ��ǰһλ�߷֣��͸���ǰһλ��1���ǹ��������1
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                nums[i] = nums[i-1] + 1;
            }else {
                nums[i] = 1;
            }
        }
        //�ڵ�����������ǰһλ�Ⱥ�һλ�߷ֲ��ҵõ����ǹ�С�ڻ���ں�һλ���͸�ǰһλ���ӱȺ�һλ���Ӷ�һ���ǹ�
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
