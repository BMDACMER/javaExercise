import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class Test35 {
    public static int FirstNotRepeatingChar(String str) {
        if (str==null || str.length() == 0)
            return -1;

        // 統計字符串各字符出现的次数
        char[] chr = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chr.length; i++) {
            if (!map.containsKey(chr[i])) {
                map.put(chr[i],1);
            } else {
                map.put(chr[i],map.get(chr[i])+1);
            }
        }
        // 遍历整个数组，寻找首次为一次的字符串
        int i;
        for (i = 0; i < chr.length; i++) {
            if (map.get(chr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("sadjjjjs"));
    }
}
