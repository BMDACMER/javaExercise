package guohaoAlgorithm.剑指offer;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/7 10:18
 *
 * 剑指 Offer 19. 正则表达式匹配
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        return help(s, 0, p, 0);
    }

    HashMap<String, Boolean> memo = new HashMap<>();
    private boolean help(String s, int i, String p, int j) {
        // base case
        int m = s.length(), n = p.length();
        // 如果模式串 匹配完毕  看s串是否匹配完毕
        if (j == n) {
            return i == m;
        }
        // 如果s串匹配完毕，看模式串是否匹配完毕
        if (i == m) {
            // 如果p 没匹配完毕  一定是和*成对出现的
            if ((n - j) % 2 == 1) return false;
            // 检查是否为 x*y*z* 这种形式
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*')
                    return false;
            }
            return true;
        }

        // 记录状态(i,j),消除重复子问题
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 匹配0次和多次
                res = help(s, i, p, j + 2) || help(s, i + 1, p, j);
            } else {
                // 常规匹配  都移动一位
                res = help(s, i + 1, p, j + 1);
            }
        }else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 匹配0次
                res = help(s, i, p, j + 2);
            } else {
                // 常规不匹配
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
