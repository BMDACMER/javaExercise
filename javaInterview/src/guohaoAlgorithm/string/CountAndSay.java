package guohaoAlgorithm.string;

/**
 * @Author guohao
 * @Date 2021/3/10 10:10
 * @Version 1.0
 *
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 */
public class CountAndSay {
    // 直接暴力求解  题意要求 1<=n<=30
    // 参考：https://leetcode-cn.com/problems/count-and-say/solution/shua-chuan-lc-100-mo-ni-ti-shi-yong-shao-w8jl/
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = nextString(s);
        }
        return s;
    }

    private String nextString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int cnt = 1;
        char ch = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ch) {
                cnt++;
            }else {
                sb.append(cnt);
                sb.append(ch);

                ch = chars[i];
                cnt = 1;
            }
        }
        // 将最后一次也放进去
        sb.append(cnt);
        sb.append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        for (int i = 1; i <= 8; i++) {
            System.out.println(c.countAndSay(i));
        }
    }
}
