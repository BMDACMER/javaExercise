package lintcode.greed;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/27 9:27
 *
 * ��ʵ˵�ļ򵥵㣬��2�������
 *
 * ���������У�ͻȻ�и�����С�ˣ���nums[i]=nums[i-1]
 * ���������У�ͻȻ�и����ִ��ˣ���nums[i-1]=nums[i]
 *
 * ���ߣ�gycs
 * ���ӣ�https://leetcode-cn.com/problems/non-decreasing-array/solution/fen-2chong-qing-kuang-by-gycs/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
public class NoDecreaseArray {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i -1] <= nums[i]){
                continue;
            }
            count++;//�����벻Ҫ���������жϵ��ڲ���һ��Ҫȷ��ֻҪ������ǵݼ��ͱ���ִ��������
            if(i - 2 >= 0 && nums[i-2] > nums[i]){//���������ͻȻ������һ����ǰһ����С�����֣�ͬʱС����ǰһ����ǰһ������
                nums[i] = nums[i - 1];//�������Ǹ��µ�i��λ�õ����ݣ���֤��ǵݼ��У�����Ҫ���ģ���Ϊ����֮ǰ���������Ѿ�+1��
            }
            else{//���������ͻȻ������һ����ǰһ����С�����֣����Ǵ�����ǰһ����ǰһ������
                nums[i-1] = nums[i];//�������Ǹ��µ�i��λ�õ����ݣ���֤��ǵݼ��У�����Ҫ���ģ���Ϊ����֮ǰ���������Ѿ�+1��
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
