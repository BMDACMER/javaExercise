package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 10:11
 *
 * 自己想起来的 大数乘法
 */
public class BigNumberMultiply {

    // 大数相乘
    public String multiply(String num1, String num2) {
        // 排除特殊情况
        if (num1 == null || "".equals(num1)) return "";
        if (num2 == null || "".equals(num2)) return "";

        // 将num1和num2转为字符串数组  方便后续计算
        char[] char1 =num1.toCharArray();
        char[] char2 = num2.toCharArray();
        // 转为int类型数组   便于计算
        int[] n1 = new int[char1.length];
        int[] n2 = new int[char2.length];
        for (int i = 0; i < char1.length; i++) {
            n1[i] = char1[i] - '0';
        }
        for (int i = 0; i < char2.length; i++) {
            n2[i] = char2[i] - '0';
        }
        // num1 * num2 的结果存储在res中，字符数组不会超过 num1.length() * num2.length()
        int[] res = new int[num1.length() + num2.length()];

        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                res[i + j] += n1[i] * n2[j];
            }
        }

        //从后往前满十进位
        int carry = 0;
        int curr;
        for (int i = res.length - 1; i > 0; --i) {
            curr = res[i] + carry;
            carry = curr / 10;
            curr %= 10;
            res[i] = curr;
        }
        if (carry != 0) res[0] += carry;  // 这一句几乎不会实现，因为两数相乘几乎不会占满整个长度

        // 转为String并返回
        String ans = "";
        for (int i = 0; i < res.length - 1; i++) {
            ans += "" + res[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        BigNumberMultiply bm = new BigNumberMultiply();
        System.out.println(bm.multiply("10","789"));
    }

}
