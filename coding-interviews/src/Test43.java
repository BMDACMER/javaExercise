import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class Test43 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        // 两数之和相等，当其差值越大，则两者乘积越小
        int len = array.length / 2;
        for (int i = 0; i < len; i++) {
            for (int j = array.length - 1; j >= len ; j--) {
                if (array[i] + array[j] == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    return list;
                }
            }
        }

        return list;
    }
}
