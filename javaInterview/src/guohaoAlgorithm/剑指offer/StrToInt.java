package guohaoAlgorithm.剑指offer;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/5 12:02
 *
 *
 * 剑指 Offer 67. 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 *
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [?231,  231 ? 1]。如果数值超过这个范围，请返回  INT_MAX (231 ? 1) 或 INT_MIN (?231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 */
public class StrToInt {

    // 击败 99.54% + 89.56%  参考: https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58mttv/
    public int strToInt(String str) {
        char[] arr = str.trim().toCharArray();
        if (arr.length == 0) return 0;
        int i = 1, sign = 1;
        if (arr[0] == '-') sign = -1;
        else if (arr[0] != '+') i = 0;

        int binary = Integer.MAX_VALUE / 10, res = 0;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] < '0' || arr[j] > '9') break;
            if (res > binary || res == binary && arr[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (arr[j] - '0');
        }

        return sign * res;
    }
}
