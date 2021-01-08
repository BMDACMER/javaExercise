package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 9:34
 *
 * 189. ��ת����
 */
public class Rotate {

    /**
     * �㷨˼·���Ƚ��������ݷ�ת���ڽ�ǰk�����鷴ת�����Ž�ʣ���len - k �����鷴ת
     * ʱ�临�Ӷ�ΪO(n)
     * �ռ临�Ӷ�ΪO(1)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        rotateArray(nums, 0, len - 1);
        rotateArray(nums, 0, k % len - 1);
        rotateArray(nums, k % len, len - 1);
    }

    private void rotateArray(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return;
    }

    /**
     * �������� ʱ�临�Ӷ�ΪO(kn)
     * �ռ临�Ӷ�ΪO(1)
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int tmp;
        for (int i = 0; i < k % len; i++) {
            tmp = nums[len - 1];  // ÿ�ζ���¼���������һ��Ԫ��
            for (int j = len - 1; j >  0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

}
