package guohaoAlgorithm.springoffer.genshuixue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 19:31
 * @Version 1.0
 *
 * 判断词链
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 判断给定的英文单词数组是否构成词链，前后两个单词，字母按次序一一对应，有且仅有一个字母不同，
 * 即abc和abd组成词链，abc和ab不构成词链，abc和 bcd不构成词链。
 *
 * 现给定一个长度N的英文单词数组，求其中相邻的N-1组单词，不能构成词链的数量
 *
 * 输入描述
 * 第一行读入一个整数，代表数组长度 N
 *
 * 之后读入N行字符串，每一行字符串代表数组中的一个单词
 *
 * 输出描述
 * 输出一行，包含一个整数，代表数组中不能构成词链的组数，都能构成词链输出0
 *
 *
 * 样例输入
 * 4
 * ape
 * app
 * ppa
 * pp
 * 样例输出
 * 2
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scan.nextLine();
        }

        // 算法部分
        String base = strs[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int count = 0;
            if (base.length() == strs[i].length()) {
                for (int j = 0; j < base.length(); j++) {
                    if (base.charAt(j) != strs[i].charAt(j)) {
                        count++;
                    }
                }
                // 词链count=1  否则不为词链
                if (count != 1) ans++;
            } else {
                ans++;
            }
            base = strs[i];
        }
        System.out.println(ans);
    }
}
