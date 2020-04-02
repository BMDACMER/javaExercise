/**
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出
 * “We%20are%20happy.”。
 */
public class Test04 {

    // 方法一：
    public static String replaceSpace(StringBuilder str){

        if (str == null){
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                stringBuilder.append('%');
                stringBuilder.append('2');
                stringBuilder.append('0');
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    // 方法二：
    /*
    问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
    问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
          从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
          从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
    */
    public static String replaceSpace2(StringBuffer str){
        if (str == null){
            return null;
        }

        int countBlank = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                countBlank++;
            }
        }

        int stringOld = str.length() - 1;   // 原始字符串长度(下标）
        int stringNew2 = str.length() + 2 * countBlank;  // 加入20%后的字符串长度
        int stringNew = stringNew2 - 1;  // 加入20%后的字符串长度(下标）
        str.setLength(stringNew2);  // 防止数组越界

        for (; stringOld >= 0; --stringOld) {
            if (str.charAt(stringOld) == ' '){
                str.setCharAt(stringNew--, '0');
                str.setCharAt(stringNew--, '2');
                str.setCharAt(stringNew--, '%');
            }else{
                str.setCharAt(stringNew--, str.charAt(stringOld));
            }
        }

        return str.toString();
    }


    public static void main(String[] args) {
//        String s = "We Are happy";
        // 方法一
        StringBuilder s = new StringBuilder("We Are happy");
        String str = replaceSpace(s);
        System.out.println(str);

        System.out.println("============================");

        // 方法二
        StringBuffer stringBuffer = new StringBuffer("We Are happy");
        System.out.println(replaceSpace2(stringBuffer));
    }
}
