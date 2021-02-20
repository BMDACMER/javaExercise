package guohaoAlgorithm.oneQuestionPerDay;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author guohao
 * @Date 2021/2/20 7:53
 * @Version 1.0
 *
 * 697. ����Ķ�
 * ����һ���ǿ���ֻ�����Ǹ������������� nums������ĶȵĶ�����ָ��������һԪ�س���Ƶ�������ֵ��
 *
 * ����������� nums ���ҵ��� nums ӵ����ͬ��С�Ķȵ�������������飬�����䳤�ȡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺[1, 2, 2, 3, 1]
 * �����2
 * ���ͣ�
 * ��������Ķ���2����ΪԪ��1��2�ĳ���Ƶ����󣬾�Ϊ2.
 * ��������������ӵ����ͬ�ȵ���������ʾ:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * �������������[2, 2]�ĳ���Ϊ2�����Է���2.
 * ʾ�� 2��
 *
 * ���룺[1,2,2,3,1,4,2]
 * �����6
 */
public class FindShortestSubArray {

    /**
     * ˼·�� �������е�Ԫ��ӳ�䵽 ����ÿ��Ԫ�س��ִ�������Ԫ���״γ��ֵ�λ�á���Ԫ�������ֵ�λ�õ� ����Ϊ3��������
     *  ͳ��Ԫ���г���Ƶ����ߵ�Ԫ�� ���Ƶ����ͬ��Ƚ���ĩλ�ò���С��Ԫ�أ������䳤��
     *
     *
     *  ִ����ʱ�� 15 ms, ������ Java �ύ�л����� 87.60%���û�
     *  �ڴ����ģ� 42.8 MB , ������ Java �ύ�л����� 36.94% ���û�
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1,i,i});
            }
        }

        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (maxNum < entry.getValue()[0]) {
                maxNum = entry.getValue()[0];
                minLen = entry.getValue()[2] - entry.getValue()[1] + 1;
            } else if (maxNum == entry.getValue()[0]){
                // Ƶ����ͬʱ  �Ƚϳ�����С��
                minLen  = Math.min(minLen, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        return minLen;
    }
}
