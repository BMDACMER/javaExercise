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

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int maxCount = Integer.MIN_VALUE, right = 0, count = 0;
        while (right < n) {
            count++;
            right++;
            if (right < n && nums[right] == nums[right - 1]) {
                count++;
            }else if (right < n){
                count = 0;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes f = new FindMaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1};
        System.out.println(f.findMaxConsecutiveOnes(nums));
    }
}
