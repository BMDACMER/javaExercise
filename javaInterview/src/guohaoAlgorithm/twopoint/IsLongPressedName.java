package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 13:26
 *
 * 925. 长按键入
 */
public class IsLongPressedName {

    /**
     * 思路：typed字符串 要满足要求 只能满足以下两种情况：
     * 1） name[i] == typed[j]   i++,j++
     * 2）j > 0  type[j] == type[j-1]  j++;
     * 如果出现name中未出现的字符则为false
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || "".equals(name) || "".equals(typed)) return false;
        if (name.length() > typed.length()) return false;

        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        IsLongPressedName test = new IsLongPressedName();
        System.out.println(test.isLongPressedName("alex", "aaleexa"));
    }
}
