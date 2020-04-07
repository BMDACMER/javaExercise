/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */

public class Test06 {
    public static int minNumberInRotateArray(int [] array) {
        // �쳣����
        if (array.length < 1 || array == null) {
            return 0;
        }
        // �����ڶ��ֲ���
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1){
            int mid = (left + right) >> 1;
            if (array[left] <= array[mid]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[right];
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
    }
}