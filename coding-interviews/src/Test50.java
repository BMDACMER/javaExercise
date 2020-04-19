/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */

/**
 * 思路：将字符串转化为整数首先是遍历字符串中的每一个字符，有三种情况：首字符是正号，首字符是负号，首字符非正负号；
 * 然后遍历每一个字符进行num = num * 10 + charArray[i] - '0'，在进行这个工作之前首先需要对charArray[i]进行是
 * 否为数字字符的判断，循环遍历直到结束，输出结果；

 注意事项（思考点）：（1）字符串中包含有非数字字符；（2）字符串中包含正负符号；（3）考虑最大的正整数；
                （4）考虑最小的负整数；（5）溢出。
 ————————————————
 原文链接：https://blog.csdn.net/u013132035/article/details/80466925
 */
public class Test50 {
    public static int StrToInt(String str) {
        if (str == null || str.length() < 1)
            return 0;
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**
         * limit 默认初始化为 负的 最大正整数 ，假如字符串表示的是正数
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较，
         * 判断是否溢出
         */
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                } else if (firstChar != '+')//第一位不是数字和-只能是+
                    return 0;
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = str.charAt(i++)-'0';//char转int
                if (digit < 0 || digit > 9)//0到9以外的数字
                    return 0;

                //判断溢出
                if (result < multmin) {
                    return 0;
                }
                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("21"));
    }
}