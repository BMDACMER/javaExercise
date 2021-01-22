package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 11:20
 *
 * 344. 反转字符串
 */
public class ReverseString {

    // 采用双指针方法
    public void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1) return;

        char ch;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
        return;
    }
}
