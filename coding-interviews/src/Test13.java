import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Test13 {
    // 方法一：  开辟二个新数组
    public static int[] reOrderArray(int [] array) {
        int length = array.length;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (array[i] % 2 != 0) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }

        int i;
        for (i = 0; i < list1.size(); i++) {
            array[i] = list1.get(i);
        }
        for (int j = 0; j < list2.size(); j++) {
            array[i++] = list2.get(j);
        }
     return array;
    }

    // 方法二  类似于插入排序
    public void reOrderArray2(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 != 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j] % 2 == 0) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }else {
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr2 = reOrderArray(arr);
        for (int i = 0; i < arr2.length; i++) {

            System.out.print(arr2[i] + " ");
        }
    }
}
