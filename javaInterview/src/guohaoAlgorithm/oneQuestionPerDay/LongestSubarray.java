package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/19 9:40
 * @Version 1.0
 *
 * 1493. ɾ��һ��Ԫ���Ժ�ȫΪ 1 ���������
 * ����һ������������ nums ������Ҫ����ɾ��һ��Ԫ�ء�
 *
 * ������ɾ��Ԫ�صĽ�������У����������ֻ���� 1 �ķǿ�������ĳ��ȡ�
 *
 * ��������������������飬�뷵�� 0 ��
 *
 *
 *
 * ��ʾ 1��
 *
 * ���룺nums = [1,1,0,1]
 * �����3
 * ���ͣ�ɾ��λ�� 2 ������[1,1,1] ���� 3 �� 1 ��
 * ʾ�� 2��
 *
 * ���룺nums = [0,1,1,1,0,1,1,0,1]
 * �����5
 * ���ͣ�ɾ��λ�� 4 �����ֺ�[0,1,1,1,1,1,0,1] ���ȫ 1 ������Ϊ [1,1,1,1,1] ��
 * ʾ�� 3��
 *
 * ���룺nums = [1,1,1]
 * �����2
 * ���ͣ������Ҫɾ��һ��Ԫ�ء�
 * ʾ�� 4��
 *
 * ���룺nums = [1,1,0,0,1,1,1,0,1]
 * �����4
 * ʾ�� 5��
 *
 * ���룺nums = [0,0,0]
 * �����0
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, count = 0, ans = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] == 1) count++;
            while (right - left + 1 > count + 1) {
                if (nums[left] == 1) count--;
                left++;
            }
            ans = Math.max(ans, count);
            right++;
        }
        return ans == n ? ans - 1 : ans;
    }

    public static void main(String[] args) {
        LongestSubarray test = new LongestSubarray();
        int[] nums = {1,1,0,0,1,1,1,0,1};
        System.out.println(test.longestSubarray(nums));
    }
}
