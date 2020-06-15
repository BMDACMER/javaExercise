package lintcode.offer;

/**
 * 替换空格
 * 思路：用字符串存储，计算原字符串的长度length和和包含的空格数n，则可以计算出新的字符串
 * 长度为length + 2n. 从后往前移动每次遇到空格就用%20替换，依次放入新的字符串中。
 */
public class Test20 {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() < 1)
            return "";
        // 统计字符串中空格数
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        StringBuffer newStr = new StringBuffer(str.length() + 2 * count);
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {   // 替换
                newStr.append('0');
                newStr.append('2');
                newStr.append('%');
            } else {
                newStr.append(str.charAt(i));   // 直接放入
            }
        }
        return newStr.reverse().toString();
    }
}
