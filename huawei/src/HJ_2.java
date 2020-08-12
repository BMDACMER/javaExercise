import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/11 22:04
 *
 * »•÷ÿ≈≈–Ú
 */
public class HJ_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int count = Integer.parseInt(input);
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int curNum = 0;
            for (int i = 0; i < count; i++) {
                if (!(curNum == arr[i])) {
                    curNum = arr[i];
                    System.out.println(arr[i]);
                }
            }
        }

    }
}
