package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 9:19
 *
 * 724. Ѱ���������������
 * ����һ���������͵����� nums�����дһ���ܹ��������� ������������ �ķ�����
 *
 * ������������������ �������� �ģ����������������������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
 *
 * ������鲻����������������ô����Ӧ�÷��� -1����������ж��������������ô����Ӧ�÷��������ߵ���һ����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺
 * nums = [1, 7, 3, 6, 5, 6]
 * �����3
 * ���ͣ�
 * ���� 3 (nums[3] = 6) �������֮�� (1 + 7 + 3 = 11)�����Ҳ���֮�� (5 + 6 = 11) ��ȡ�
 * ͬʱ, 3 Ҳ�ǵ�һ������Ҫ�������������
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;
        // ���ȼ�����������Ԫ��֮��
        int sum = 0;
        for (int num : nums) sum += num;

        // ���������е�Ԫ�� // ��������ֻ���Ǵ� [1,n-2]
        int left = 0;
        for (int i = 0; i <= n - 1; i++) {
            if (i > 0) left += nums[i - 1];
            int temp = sum - nums[i];
            if (temp % 2 != 0){
                continue;
            }

            if (left == temp / 2) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex p = new PivotIndex();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(p.pivotIndex(nums));
    }
}
