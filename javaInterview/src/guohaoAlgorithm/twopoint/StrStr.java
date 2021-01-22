package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 11:28
 *
 * 28. 实现 strStr()
 */
public class StrStr {

    // 暴力算法 -- 超时
    public int strStr2(String haystack, String needle) {
        if ("".equals(needle))  return 0;
        if (haystack == null || needle == null || "".equals(haystack) || haystack.length() < needle.length()) return -1;

       int index = 0;
       while (index < haystack.length()) {
           if (haystack.charAt(index) == needle.charAt(0)) {
               int k = index + 1;
               int i = 1;
               for (; i < needle.length(); i++, k++) {
                   if (haystack.charAt(k) != needle.charAt(i))
                       break;
               }
               if (i == needle.length()) return index;  // 找到了
           } else {
               index++;
           }
       }

        return -1;
    }

    // 直接调用内置函数
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        StrStr s = new StrStr();
        System.out.println(s.strStr("aaaaa",""));
    }
}
