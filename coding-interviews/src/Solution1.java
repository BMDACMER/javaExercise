/**
 * 题一： 统计单词数
 * 思路：统计空格数+1即为句子的单词总数
 * 如果句子中 两个单词之间有多个空格，只能算一个来统计
 * 句子中如果第一个为空格，或者最后也为空格，特殊处理， 采用去重 trim()
 *
 */
public class Solution1 {
    public static int countSegments(String s) {
        // 异常处理
        if (s.length() < 1 || s == null)
            return 0;
        // 统计单词
        int count = 0;
         String newStr = s.trim();
         if ("".equals(newStr))
             return 0;
        for (int i = 1; i < newStr.length(); i++) {
            if (newStr.charAt(i) == ' ' &&  newStr.charAt(i - 1) != ' ') {
                count++;
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("     foo   s       "));
    }
}
