package 携程;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/13 10:53
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int buyCoke(int m, int a, int b, int c, int x) {
        if (m == 0) return 0;
        int m1 = m, a1 = a, b1 = b, c1 = c, x1 = x;
        int res = 0;
        while (m1 != 0) {
            int k1 = x1 / 100;
            int k2 = x1 % 100;
            if ((k2 == 0 && c1 >= k1) || (k2 !=0 && c1 > k1)) {
                c1 -= k1;
                res += k1;
                if (k2 != 0) {
                    c1 -= 1;
                    res += 1;
                }

                b1 += k2 / 50;
                a1 += (k2%50) / 10;
            } else {
                int left = x1 - c1 * 100;
                int k3 = left / 50;
                int k4 = left % 50;
                if ((k4 ==0 && b1 >= k3) || (k4 != 0 && b1 > k3)) {
                    b1 -= k3;
                    res += k3;
                    if (k4 != 0) {
                        b1 -= 1;
                        res += 1;
                    }
                    a1 += k4 / 10;
                } else {
                    int left2 = left - b1 * 50;
                    int k5 = left2 / 10;
                    if (a1 >= k5) {
                        a1 -= k5;
                        res += k5;
                    } else {
                        return res;
                    }

                }

            }

            m1--;
        }

        return res;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));

    }
}

