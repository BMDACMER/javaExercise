package lintcode.offer;
// ��ӡ1��nλ��
public class Test36_2 {
    public int[] printNumbers(int n) {
        //����д�� ���������
        int res = 1;
        int x = 10;
        while (n != 0) {
            if ((n&1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }

        // ��ӡ1~10^10 - 1
        int len = res - 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
