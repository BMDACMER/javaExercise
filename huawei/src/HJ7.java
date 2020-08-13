import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/13 15:47
 */
public class HJ7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(input);
            while (sb.length() >= 8) {
                System.out.println(sb.toString().substring(0,8));
                sb.delete(0,8);
            }
            if (sb.length() < 8 && sb.length() > 0) {
                sb.append("0000000");  // 7¸ö0
                System.out.println(sb.toString().substring(0,8));
            }
        }
    }
}
