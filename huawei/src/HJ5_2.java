import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/12 20:40
 *
 * 分割字符串
 */
public class HJ5_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                // 接收以下输入的行
                input = br.readLine();
                int len = input.length() / 8;
                if (input.length() % 8 > 0)
                    len++;
                int start = 0;
                int end = 8;
                for (int i = 0; i < len; i++) {
                    if (input.length() < end)
                        end = input.length();
                    String current = input.substring(start,end);
                    sb.append(current);

                    for (int j = 0; j < 8 - current.length(); j++) {
                        sb.append("0");
                    }
                    sb.append("\n");
                    start+=8;
                    end+=8;
                }
                n--;
            }
            System.out.println(sb.toString().trim());
        }
    }
}
