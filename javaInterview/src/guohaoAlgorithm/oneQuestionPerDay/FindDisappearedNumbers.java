package guohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author guohao
 * @Date 2021/2/13 10:28
 * @Version 1.0
 *
 * 448. �ҵ�������������ʧ������
 * ����һ����Χ��  1 �� a[i] �� n ( n = �����С ) �� �������飬�����е�Ԫ��һЩ���������Σ���һЩֻ����һ�Ρ�
 *
 * �ҵ������� [1, n] ��Χ֮��û�г����������е����֡�
 *
 * �����ڲ�ʹ�ö���ռ���ʱ�临�Ӷ�ΪO(n)�������������������? ����Լٶ����ص����鲻���ڶ���ռ��ڡ�
 *
 * ʾ��:
 *
 * ����:
 * [4,3,2,7,8,2,3,1]
 *
 * ���:
 * [5,6]
 */
public class FindDisappearedNumbers {

    // ʱ�临�ӶȺͿռ临�ӶȾ�Ϊ O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[n + 1];
        arr[0] = 1;  // �׳�0���Ԫ��
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
     * ʱ�临�ӶȺͿռ临�ӶȾ�Ϊ O(n)
     *
     * ������˵������ nums��ÿ����һ���� x������ nums[x?1] ���� n��
     * ���� nums ������������ [1,n] �У������Ժ���Щ����Ȼ���� n��������Ǳ���
     * nums���� nums[i] δ���� n����˵��û���������� i+1���������Ǿ��ҵ���ȱʧ�����֡�
     *
     * ע�⣬�����Ǳ�����ĳ��λ��ʱ�����е��������Ѿ������ӹ��������Ҫ�� nȡģ����ԭ����������ֵ��
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
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
