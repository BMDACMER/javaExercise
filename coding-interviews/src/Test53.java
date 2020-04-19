/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 * 在本题中， * 匹配是指字符串的
 * 所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Test53 {
    public static boolean match(char[] str, char[] pattern) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (char c : str) {
            s1.append(c);
        }
        for (char c : pattern) {
            s2.append(c);
        }
        return solve(s1.toString(),s2.toString(),0,0);
    }
    
    public static boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    /**
     *  字符串匹配
     * @param s   字符串1
     * @param p   字符串2
     * @param index1  字符串1 的下标
     * @param index2   字符串2的下标
     * @return   当前s今儿p的匹配结果
     */
    private static boolean solve(String s, String p, int index1, int index2) {
        // 递归终止条件1
        if (index1 == s.length()  && (index2 == p.length()  || (index2 + 1 == p.length() -1  && p.charAt(index2 + 1) == '*'))) {
            return true;
        }
        //  递归终止条件2
        if (index1 == s.length()  || index2 == p.length()) {
            if (index1 == s.length()) {
                return change(p, index2);
            } else {
                return false;
            }
        }


        // p当前字符的下一个位置的字符时 *
        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
            if (judge(s.charAt(index1),p.charAt(index2))) {
                return solve(s, p, index1, index2 + 2) || solve(s, p, index1 + 1, index2);
            } else {
                return solve(s, p, index1, index2 + 2);
            }
        }

        // 当前两个下标所指的字符匹配
        if (judge(s.charAt(index1), p.charAt(index2))) {
            return solve(s, p , index1 + 1, index2 + 1);
        }

        return false;
    }

    private static boolean change(String p, int index2) {
        while (index2 < p.length()) {
            if (index2 + 1 <p.length() && p.charAt(index2 + 1) == '*') {
                index2 += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param s1  字符1
     * @param s2  字符2
     * @return   两个字符是否匹配的结果
     */
    private static boolean judge(char s1, char s2) {
        if (s1 == s2 || s2 == '.') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa","ab*ac*a"));
    }
}
