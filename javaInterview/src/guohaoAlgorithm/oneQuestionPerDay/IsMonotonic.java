package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/28 9:10
 * @Version 1.0
 *
 * 896. ��������
 * ��������ǵ��������򵥵��ݼ��ģ���ô���ǵ����ġ�
 *
 * ����������� i <= j��A[i] <= A[j]����ô���� A �ǵ��������ġ� ����������� i <= j��A[i]> = A[j]����ô���� A �ǵ����ݼ��ġ�
 *
 * ������������ A �ǵ�������ʱ���� true�����򷵻� false��
 *
 *
 *
 * ʾ�� 1��
 * ���룺[1,2,2,3]
 * �����true
 *
 * ʾ�� 2��
 * ���룺[6,5,4,4]
 * �����true
 *
 * ʾ�� 3��
 * ���룺[1,3,2]
 * �����false
 */
public class IsMonotonic {

    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if (n == 1) return true;

        int increase = 1, decrease = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] - A[i - 1] >= 0) {
                increase++;
            }
            if (A[i] - A[i - 1] <= 0) {
                decrease++;
            }
        }

        return increase == n || decrease == n;
    }

    // �Ż��㷨  ---- ����100%
    public boolean isMonotonic2(int[] A) {
        return isSorted(A, true) || isSorted(A, false);
    }

    public boolean isSorted(int[] A, boolean increasing) {
        int n = A.length;
        if (increasing) {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
