/**
 * ͳ��һ�����������������г��ֵĴ�����
 */
public class Test38 {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) {
            return 0;   // ����û�ҵ�
        }
        // ���ֲ���
        int start = 0;
        int end = array.length - 1;

        int first = getFirstPosition(array, k, start,end);
        int last = getLastPosition(array, k, start,end);

        if (array[first] != k) {
            return 0;
        }

        return last - first + 1;
    }

    // �ҵ����һ��Ԫ�صĽ��λ��
    private int getLastPosition(int[] array, int k, int start, int end) {
        while (start < end) {
            int mid = (start + end) >> 1;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] == k) {
                if (mid + 1 < array.length && array[mid + 1] == k) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return start;
    }
    // �ҵ���һ��Ԫ�صĽ��λ��
    private int getFirstPosition(int[] array, int k, int start, int end) {
        while (start < end) {
            int mid = (start + end) >> 1;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] == k) {
                if (mid - 1 >= 0 && array[mid - 1] == k) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,2,3};
        System.out.println(new Test38().GetNumberOfK(arr,2));
    }
}
