package lintcode.offer;
// 打印1到n位数
public class Test36_2 {
    public int[] printNumbers(int n) {
        //错误写法 不考虑溢出
        int res = 1;
        int x = 10;
        while (n != 0) {
            if ((n&1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }

        // 打印1~10^10 - 1
        int len = res - 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
