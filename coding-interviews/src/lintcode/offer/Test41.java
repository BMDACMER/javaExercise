package lintcode.offer;
// 21 调整数组顺序使奇数位于偶数前面
public class Test41 {
    public void reOrderArray(int [] array) {
        int[] copy = array.clone();
        // 统计奇数个数
        int count = 0;
        for (int i : copy) {
            if (i % 2 != 0)
                count++;
        }

        // 将原数组中的元素整理到 copy数组中：奇数在前 偶数在后
        int i = 0, j = count;
        for (int val : copy) {
            if (val % 2 != 0) {
                array[i++] = val;
            } else {
                array[j++] = val;
            }
        }

    }
}
