/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * 解题思路：归并排序
 */
public class Test36 {
    private long sum;
    public int InversePairs(int [] array) {
        sum = 0;
        int l = 0;
        int r = array.length - 1;
        divide(l, r, array);
        return (int)(sum %1000000007);
    }

    private void divide(int l, int r, int[] array) {
        if (l != r) {
            int mid = (l + r) >> 1;
            divide(l, mid, array);
            divide(mid + 1, r, array);
            merge(l,r,mid,array);
        }
    }

    private void merge(int l, int r, int mid, int[] array) {
        int i = l;
        int j = mid + 1;
        int[] temp = new int[r - l + 1];
        int index = 0;
        while (i <= mid && j <= r) {
            if (array[i] > array[j]){
                temp[index++] = array[j++];
                sum += mid - i + 1;
            }else {
                temp[index++] = array[i++];
            }
        }

        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= r) {
            temp[index++] = array[j++];
        }

        index = 0;
        for (int k = l; k <= r; k++) {
            array[k] = temp[index++];
        }
    }
}
