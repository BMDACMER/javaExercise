package lintcode.offer;
// 17 打印从1到最大的n位数
// 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
public class Test36 {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }
    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }
    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    public static void main(String[] args) {
        Test36 t = new Test36();
        t.print1ToMaxOfNDigits(2);
    }
}
