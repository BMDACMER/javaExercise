/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Test28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        int[] arr = new int[102400000];   // 统计每个数字出现的次数
        int count = 0;  // 统计目标数字的出现的次数
        for (int i = 0; i < len; i++) {
            arr[array[i]] ++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > (len / 2)) {
                return i;
            }
        }
        return 0;
    }



}
