import java.util.ArrayList;

/**
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 *
 * ��Ӧÿ�����԰����������������С���������
 */
public class Test43 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        // ����֮����ȣ������ֵԽ�������߳˻�ԽС
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
