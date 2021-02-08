package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/8 9:15
 *
 * 978. �����������
 * �� A �������� A[i], A[i+1], ..., A[j] ������������ʱ�����ǳ���Ϊ���������飺
 *
 * �� i <= k < j���� k Ϊ����ʱ�� A[k] > A[k+1]���ҵ� k Ϊż��ʱ��A[k] < A[k+1]��
 * �� �� i <= k < j���� k Ϊż��ʱ��A[k] > A[k+1] ���ҵ� k Ϊ����ʱ�� A[k] < A[k+1]��
 * Ҳ����˵������ȽϷ������������е�ÿ������Ԫ�ض�֮�䷭ת����������������������顣
 *
 * ���� A ���������������ĳ��ȡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺[9,4,2,10,7,8,8,1,9]
 * �����5
 * ���ͣ�(A[1] > A[2] < A[3] > A[4] < A[5])
 * ʾ�� 2��
 *
 * ���룺[4,8,12,16]
 * �����2
 *
 * ��ʾ��
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class MaxTurbulenceSize {

    // ˫ָ�� ģ�⻬������
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len;
        }

        // �� arr[i] ��β������ arr[i - 1] < arr[i] ������������ĳ���
        int[] increased = new int[len];
        // �� arr[i] ��β������ arr[i - 1] > arr[i] ������������ĳ���
        int[] decreased = new int[len];

        increased[0] = 1;
        decreased[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] < arr[i]) {
                increased[i] = decreased[i - 1] + 1;
                decreased[i] = 1;
            } else if (arr[i - 1] > arr[i]) {
                decreased[i] = increased[i - 1] + 1;
                increased[i] = 1;
            } else {
                increased[i] = 1;
                decreased[i] = 1;
            }

            res = Math.max(res, Math.max(increased[i], decreased[i]));
        }
        return res;
    }

    // ״̬ѹ��
    public int maxTurbulenceSize2(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len;
        }
        int increased = 1, decreased = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] < arr[i]) {
                increased = decreased + 1;
                decreased = 1;
            } else if (arr[i - 1] > arr[i]) {
                decreased = increased + 1;
                increased = 1;
            } else {
                increased = 1;
                decreased = 1;
            }
            res = Math.max(res, Math.max(increased, decreased));
        }
        return res;
    }

    public static void main(String[] args) {
        MaxTurbulenceSize test = new MaxTurbulenceSize();
        int[] nums = {0,1,1,0,1,0,1,1,0,0};
        System.out.println(test.maxTurbulenceSize2(nums));
    }
}
