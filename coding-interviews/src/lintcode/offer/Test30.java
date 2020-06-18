package lintcode.offer;

/**
 * 11 旋转数组的最小数字
 * 类似二分查找 寻找最小值
 */
public class Test30 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (array[left] == array[middle] && array[middle] == array[right])
                return minNumber(array, left, right);
            else if (array[middle] > array[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return array[left];
    }

    private int minNumber(int[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            if (array[left] > array[left + 1])
                return array[left+1];
        }
        return array[left];
    }
}
