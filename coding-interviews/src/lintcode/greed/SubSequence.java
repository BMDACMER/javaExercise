package lintcode.greed;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/27 8:51
 */
public class SubSequence {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (Character c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SubSequence subSequence = new SubSequence();
        System.out.println(subSequence.isSubsequence("abccc","ahbgdc"));
    }
}
