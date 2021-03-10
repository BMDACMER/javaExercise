package guohaoAlgorithm.math;

/**
 * @Author guohao
 * @Date 2021/3/10 11:11
 * @Version 1.0
 *
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 */
public class TitleToNumber {

    // 相等于求解 26进制
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) return 0;
        char[] chars = columnTitle.toCharArray();
        int ans = chars[0] - 'A' + 1;
        for (int i = 1; i < chars.length; i++) {
            ans = ans * 26 + chars[i] - 'A' + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        TitleToNumber t = new TitleToNumber();
        System.out.println(t.titleToNumber("AB"));
    }

}
