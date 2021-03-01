package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/3/1 9:05
 * @Version 1.0
 *
 * 303. ����ͼ��� - ���鲻�ɱ�
 * ����һ����������  nums�������������� i �� j��i �� j����Χ��Ԫ�ص��ܺͣ����� i��j ���㡣
 *
 * ʵ�� NumArray �ࣺ
 *
 * NumArray(int[] nums) ʹ������ nums ��ʼ������
 * int sumRange(int i, int j) �������� nums ������ i �� j��i �� j����Χ��Ԫ�ص��ܺͣ�
 * ���� i��j ���㣨Ҳ���� sum(nums[i], nums[i + 1], ... , nums[j])��
 *
 *
 * ʾ����
 *
 * ���룺
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * �����
 * [null, 1, -1, -3]
 *
 * ���ͣ�
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class NumArray {

    // �����㷨   ����25%
    /*int[] arr;
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j >= arr.length || i > j) throw new IllegalThreadStateException();
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }*/

    // ǰ׺��
    int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return arr[j+1] - arr[i];
    }
}
