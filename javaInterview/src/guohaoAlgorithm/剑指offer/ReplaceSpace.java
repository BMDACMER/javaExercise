package guohaoAlgorithm.剑指offer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 9:52
 *
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {

    // 效率： 【100%，90.34%】
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return "";
        // 1)统计空格
        int count = 0, len = s.length();
        for (char c : s.toCharArray()) {
            if (c == ' ') count++;
        }
        int n = len + 2 * count;
        char[] ans = new char[n];
        int index = n - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                ans[index--] = '0';
                ans[index--] = '2';
                ans[index--] = '%';
            }else {
                ans[index--] = s.charAt(i);
            }
        }
        return new String(ans);
    }

}
