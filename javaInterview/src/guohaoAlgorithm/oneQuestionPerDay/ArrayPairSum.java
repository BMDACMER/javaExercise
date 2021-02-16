package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;

/**
 * @Author guohao
 * @Date 2021/2/16 8:15
 * @Version 1.0
 *
 * 561. ������ I
 * ��������Ϊ 2n ���������� nums ����������ǽ���Щ���ֳ� n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô� 1 �� n �� min(ai, bi) �ܺ����
 *
 * ���ظ� ����ܺ� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,4,3,2]
 * �����4
 * ���ͣ����п��ܵķַ�������Ԫ��˳��Ϊ��
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * ��������ܺ�Ϊ 4
 * ʾ�� 2��
 *
 * ���룺nums = [6,2,6,5,1,2]
 * �����9
 * ���ͣ����ŵķַ�Ϊ (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 */
public class ArrayPairSum {

    // 13ms  ����96.18%   62.02%���û�
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
