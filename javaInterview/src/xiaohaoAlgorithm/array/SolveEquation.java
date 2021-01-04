package xiaohaoAlgorithm.array;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 16:52
 *
 * 640. 求解方程
 */
public class SolveEquation {

    /**
     * 思路：将等式的根据 = （等号）分割成两部分 将x移动左边，剩下的字符串（数字）一道另一端
     * 用 +- 代替 -  便于后续操作
     *
     *      若 x出现的次数为0且常数系数不为零，则 x为 Infinite solutions
     *      若 x出现的次数不为0，则剩下的元素之和 处于x的次数即为x的值
     *      若x=出现的次数为0，剩下元素之和不为0，则 No solution
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        int xCoefficient = 0, constantCoefficient = 0;
        int op = 1;   // 默认左边为1  右边为-1；
        for (String eq : equation.split("=")) {
            eq.replace("-","+-");
            for (String num : eq.split("\\+")) {
                // 针对包含x的情况
                if (num.contains("x")) {
                    // 针对只有x的情况
                    if (num.length() == 1) xCoefficient += op;
                    // 针对 -x情况
                    else if (num.length() == 2 && num.contains("-")) xCoefficient += -op;
                    else xCoefficient += op * Integer.parseInt(num.substring(0,num.length() - 1));
                }else {
                    constantCoefficient += op * Integer.parseInt(num);
                }
            }
            op = -1;  // 反转
        }
        // 若 x出现的系数为0且常数系数为零，则 x为 Infinite solutions
        if (xCoefficient == 0 && constantCoefficient == 0) return "Infinite solutions";
        // 若x系数为零且常数系数不为0
        else if (xCoefficient == 0 && constantCoefficient != 0) return "No solution";
        else return "x=" +  (-1 * constantCoefficient * (double) 1 / xCoefficient);
    }

}
