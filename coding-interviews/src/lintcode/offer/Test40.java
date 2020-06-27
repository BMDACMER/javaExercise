package lintcode.offer;

/// 表示数值的字符串

/**
 * [] ： 字符集合
 * () ： 分组
 * ? ： 重复 0 ~ 1
 * + ： 重复 1 ~ n
 * * ： 重复 0 ~ n
 * . ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 */
public class Test40 {
    public boolean isNumeric(char[] str) {
        if (str == null)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
