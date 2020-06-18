package lintcode.offer;

/**
 * ì³²¨ÄÇÆõÊıÁĞ
 */
public class Test26 {
    private int[] arr = new int[40];

    public int Fibonacci(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
