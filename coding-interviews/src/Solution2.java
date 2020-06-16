import java.util.ArrayList;
import java.util.Collections;

/**
 * �������� k �����㷵�غ�Ϊ k ��쳲��������ֵ�������Ŀ�����У�ÿ��쳲��������ֶ����Ա�ʹ�ö�Ρ�
 * ˼·������쳲������Ķ����ҳ�֮ǰ���������֣�Ȼ��ֱ��ǰ�ʹӺ��ҳ���Ϊ����ֵ������
 * �ٸ�������k�����������������һ��쳲��������֣�Ȼ����ʣ�µ�����ǰ����̰���㷨��⣬��ò��ʱ�临�Ӷ��е�ߣ�
 */
public class Solution2 {
    int count = 0;  // ͳ��������Ŀ
    public int findMinFibonacciNumbers(int k) {
        int[] arr = new int[45];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        for (int i = arr.length-1; i >= 0; i--) {
            if (k >= arr[i]) {
                k -= arr[i];
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.findMinFibonacciNumbers(645157245));
    }
}
