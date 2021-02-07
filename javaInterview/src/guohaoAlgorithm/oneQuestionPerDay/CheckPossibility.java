package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/7 9:26
 *
 * 665. �ǵݼ�����
 * ����һ������Ϊ n ���������飬�����ж��� ��� �ı� 1 ��Ԫ�ص�����£��������ܷ���һ���ǵݼ����С�
 *
 * ��������������һ���ǵݼ����еģ� �������������е� i (0 <= i <= n-2)�������� nums[i] <= nums[i + 1]��
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: nums = [4,2,3]
 * ���: true
 * ����: �����ͨ���ѵ�һ��4���1��ʹ������Ϊһ���ǵݼ����С�
 * ʾ�� 2:
 *
 * ����: nums = [4,2,1]
 * ���: false
 * ����: �㲻����ֻ�ı�һ��Ԫ�ص�����½����Ϊ�ǵݼ����С�
 */
public class CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int n = nums.length, count = 0;  // count������¼�ݼ�������
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i-1]) continue;
            count++;
            if (i - 2 >= 0 && nums[i] < nums[i - 2])
                nums[i] = nums[i-1];
            else nums[i-1] = nums[i];
        }
        return count < 2;
    }
}
