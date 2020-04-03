import java.util.Scanner;

/**
 * Сǿ�ľ����ҳ��涨�м�֮��ֵ
 */
public class ValueNumber {

    // getMaxValue
    public static int getMaxValue(int[] al, int r){
        int max = al[0];
        for (int i = 0; i <= r; i++) {
            if (max < al[i]){
                max = al[i];
            }
        }
        return max;
    }

    // getMinValue
    public static int getMinValue(int[] ar, int start, int end){
        int min = ar[start];
        for (int i = start; i < end; i++) {
            if (min > ar[i]){
                min = ar[i];
            }
        }
        return min;
    }

    public static int hasValue(int[] a, int n){
        int count = 0;
        int maxValue;
        int minValue;
        // �쳣����   ���Ϲ���޳�
        if (n < 3){
            return 0;
        }

        // �����м�ֵ����(�������ٴ��ڵ���3)
        // �ٶ����������ڵ�
        for (int i = 1; i < n-1; i++) {
           maxValue = getMaxValue(a,  i-1);
           minValue = getMinValue(a,i+1, n);
           if (maxValue > a[i] && minValue < a[i]) {
               if (maxValue % minValue == 0) {
                   count++;
               }
           }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10000];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a[i] = temp;
        }
        int count = hasValue(a, n);
        System.out.println(count);
    }
}
