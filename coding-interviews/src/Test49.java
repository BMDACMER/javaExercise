/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Test49 {
    public static int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;  // 异或相当于计算低位
            num2 = (num1&num2)<<1;  // 相当于进位
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(Add(5,7));
    }
}
