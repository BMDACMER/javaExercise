import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

/**
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7��
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */
public class Test34 {
    public static int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] a = new int[index];
        a[0] = 1;
       int index1 = 0;
       int index2 = 0;
       int index3 = 0;

        for (int i = 1; i < index; i++) {
            a[i] = Math.min(Math.min(a[index1], a[index2]), a[index3]);
            if (a[i] == a[index1] * 2) {
                index1++;
            }
            if (a[i] == a[index2] * 3) {
                index2++;
            }
            if (a[i] == a[index3] * 5) {
                index3++;
            }
        }
        return a[index-1];
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(2));
    }
}
