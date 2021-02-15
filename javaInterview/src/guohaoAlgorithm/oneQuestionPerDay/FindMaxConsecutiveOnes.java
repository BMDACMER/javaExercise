package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/15 9:02
 * @Version 1.0
 *
 * 485. �������1�ĸ���
 * ����һ�����������飬 ���������������1�ĸ�����
 *
 * ʾ�� 1:
 *
 * ����: [1,1,0,1,1,1]
 * ���: 3
 * ����: ��ͷ����λ��������λ��������1�������������1�ĸ����� 3.
 * ע�⣺
 *
 * ���������ֻ���� 0 ��1��
 * ��������ĳ��������������Ҳ����� 10,000��
 */
public class FindMaxConsecutiveOnes {

    // ִ��3ms
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int maxCount = Integer.MIN_VALUE, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 1) {
                left = right + 1;
            }
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }

    // ִ��2ms
    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxCount = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);   // ���ȫ1�����
        return maxCount;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes f = new FindMaxConsecutiveOnes();
        int[] nums = {1,1,0};
        System.out.println(f.findMaxConsecutiveOnes(nums));
    }
}
