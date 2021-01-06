package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 11:15
 *
 * 410. �ָ���������ֵ
 *
 * ��1011�� D �����ʹ���������� ����
 */
public class SplitArray {

    /**
     * �㷨˼�룺 ���ֲ���
     * Ҫ������������
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0; //�ֱ��ʾ�ָ�����������䡾left, right��
        for (int i = 0; i < nums.length; i++) {
            if (left < nums[i]) {
                left = nums[i];
            }
            right += nums[i];
        }
        right++;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int[] nums, int m, int mid) {
        int i = 0;

        for (int j = 0; j < m; j++) {
            int cap = mid;
            while ((cap -= nums[i]) >= 0) {
                i++;
                if (i == nums.length) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArray sa = new SplitArray();
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(sa.splitArray(nums, m));
    }
}
