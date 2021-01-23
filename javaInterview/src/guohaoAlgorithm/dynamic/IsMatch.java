package guohaoAlgorithm.dynamic;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 21:25
 *
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class IsMatch {

    /**
     * 给你一个字符串?s?和一个字符规律?p，请你来实现一个支持 '.'?和?'*'?的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖?整个?字符串?s的，而不是部分字符串。
     */
    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    HashMap<String, Boolean> memo = new HashMap<>();

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        // base case
        if (j == n)
            return i == m;
        if (i == m) {
            // 如果能匹配空船，一定是字符和*成对出现
            if ((n - j) % 2 == 1)
                return false;
            // 检查是否为x*y*z*这种形式
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*')
                    return false;
            }
            return true;
        }

        // // 记录状态(i,j), 消除重叠子问题
        StringBuilder sb = new StringBuilder();
        sb.append(i).append(",").append(j);
        String key = sb.toString();

         if (memo.containsKey(key)) return memo.get(key);

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 通配符返回0次或多次
                res = dp(s, i, p, j+2) || dp(s, i+1, p, j);
            }else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 不匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 通配符匹配零次
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        // 将当前结果记录备忘录
         memo.put(key, res);

        return res;
    }


}
