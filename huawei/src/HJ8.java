import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/13 16:01
 * <p>
 * ˼·����һ�����飬���ڷ�������Ҫ����ַ�����һ�α���ԭ�����ַ�����������������ǰ���*��֪������������ �����*
 */
public class HJ8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            System.out.println(MarkNum(input, sb));
        }
    }

    public static String MarkNum(String pInStr, StringBuilder sb) {
        if (pInStr.length() < 1 || pInStr == null)
            return null;

        for (int i = 0; i < pInStr.length(); ++i) {
            if (pInStr.charAt(i) >= '0' && pInStr.charAt(i) <= '9') {
                sb.append("*");

                while (i < pInStr.length() && pInStr.charAt(i) >= '0' && pInStr.charAt(i) <= '9') {
                    sb.append(pInStr.charAt(i));
                    i++;
                }

                sb.append("*");
            }
            if (i < pInStr.length())
                sb.append(pInStr.charAt(i));
        }

        return sb.toString();
    }
}
