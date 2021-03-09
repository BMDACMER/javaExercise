package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/3/9 8:36
 * @Version 1.0
 *
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) return S;
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            sb.append(ch);
        }

        // 一次遍历Stringbuilder中的字符，将相邻的两元素移除，接着cur指向当前删除元素的前一个字符，重复操作 直到遍历到末尾
        int cur = 0;
        while (sb.length() >= 0 && cur < sb.length()) {
            if (cur + 1 < sb.length() && sb.charAt(cur) == sb.charAt(cur+1)) {
                sb.deleteCharAt(cur);
                sb.deleteCharAt(cur); // 删完后后面的元素 往前移动一位  此时删除的是原来的cur+1的位置
                if (cur > 0) cur = cur - 1;
            } else {
                cur++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        String s = "bbaca";
        System.out.println(test.removeDuplicates(s));
    }
}
