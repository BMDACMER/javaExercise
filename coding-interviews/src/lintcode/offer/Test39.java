package lintcode.offer;
// 19  正則表達式匹配

/**
 * https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c?answerType=1&f=discussion
 */
public class Test39 {
    public boolean match(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }

    private boolean matchStr(char[] str, int i, char[] pattern, int j) {
        // 边界
        if (str.length == i && pattern.length == j) // 完全匹配
            return true;
        else if (pattern.length == j)                // 模式串为空，字符串不为空，匹配失败
            return false;
        // 判断下一个字符是否为'*'
        boolean next = (j + 1 < pattern.length) && (pattern[j+1] == '*');  // 模式串中下一个是否为*
        if (next) {
            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i])) {   // * 匹配的为 0次
                return matchStr(str,i,pattern,j+2) || matchStr(str,i+1,pattern,j);
            } else {
                return matchStr(str,i,pattern,j+2);
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i])) {
                return matchStr(str,i+1, pattern,j+1);
            } else {
                return false;
            }
        }
    }
}
