import java.util.ArrayList;
import java.util.Collections;

/**
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
 * ������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,
 * �������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8
 * (�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 */
public class Test30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        int sum;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                list.add(sum);
            }
        }

        if (list.size() < 1) return 0;
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
