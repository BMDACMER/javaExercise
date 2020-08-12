import java.io.IOException;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/10 21:59
 *
 * 统计字串的个数
 */
public class HJ3 {

    public static int getCount(String str, char a) {
        int count = 0;
        if (str.length() == 0 || str == null) {
            return count;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (a == str.charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String str = scan.next();
            char a = scan.next().toUpperCase().charAt(0);
            int i = getCount(str.toUpperCase(),a);
            System.out.println(i);
        }
    }
}
