package lintcode.doublepointer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 12:37
 *
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] arrIndex = new int[2];
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] == target) {
                arrIndex[0] = i + 1;
                arrIndex[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }

        }
        return arrIndex;
    }
}
