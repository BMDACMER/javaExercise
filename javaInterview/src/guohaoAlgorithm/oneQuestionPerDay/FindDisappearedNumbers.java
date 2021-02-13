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
}
