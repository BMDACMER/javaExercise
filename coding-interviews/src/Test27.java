import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Test27 {
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            Permutation(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    private void Permutation(char[] chars, int i, List<String> res) {

        if (i == chars.length - 1) {
            String val = String.valueOf(chars);
            if (!res.contains(val))
                res.add(val);
        }else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                Permutation(chars, i+1, res);
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
