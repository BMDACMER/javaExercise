import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ������
 * ��ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}��
 * ���ӡ���������������ųɵ���С����Ϊ321323��
 */
public class Test33 {
    public static String PrintMinNumber(int[] numbers) {
       ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });

        String str = "";
        for (int s : list) {
            str += s;
        }
        return str;
    }


    public static void main(String[] args) {
        int[] num = new int[]{3, 32, 321};  // ���Կ�100������
        System.out.println(PrintMinNumber(num));
    }
}
