import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */
public class Test13 {
    // ����һ��  ���ٶ���������
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

    // ������  �����ڲ�������
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
