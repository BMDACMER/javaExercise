/**
 ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
 ����ʹ�ó�������ע�⣺�涨B[0] = A[1] * A[2] * ... * A[n-1]��B[n-1] = A[0] * A[1] * ... * A[n-2];��
 */
public class Test52 {
    public static int[] multiply(int[] A) {
        if (A == null || A.length < 1) {
            return null;
        }
        int[] b = A.clone();
        for (int i = 0; i < b.length; i++) {
            int temp = 1;
            for (int j = A.length - 1; j > 0 ; j--) {
                if (j == i) {
                    continue;
                } else {
                    temp *= A[j];
                }
            }
            b[i] = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        int[] bb = multiply(arr);
        for (int i = 0; i < bb.length; i++) {
            System.out.print(bb[i] + " ");
        }
    }
}
