package lintcode.offer;

/**
 * 面试题05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
   输出："We%20are%20happy."
 */
public class Test03 {
    // 法一： 开辟新数组
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();

    }

    // 法二：  所有元素只移动一次
    public String replaceSpace2(String s) {
        if (s == null || s.length() < 1)
            return null;

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch);
        }

        // 统计空格
        int countBlank = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                countBlank++;
            }
        }

        int strNewLen = sb.length() + 2 * countBlank;
        sb.setLength(strNewLen);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(--strNewLen,'0');
                sb.setCharAt(--strNewLen,'2');
                sb.setCharAt(--strNewLen,'%');
            } else {
                sb.setCharAt(--strNewLen,sb.charAt(i));
            }
        }
        return sb.toString();
    }

}
