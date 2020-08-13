import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/13 16:34
 *
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 */
public class HJ9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
/*
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int[] arr = new int[n];
            int countNegative = 0;
            Double avg = 0.0;
            Double sumPositive = 0.0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine().trim());

                if (arr[i] < 0) {
                    countNegative++;
                } else if (arr[i] > 0){
                    sumPositive += arr[i];
                }
            }

            System.out.println(countNegative + " " + Math.round(sumPositive * 10.0/ (n - countNegative))/10.0 );
        }
        */

        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            String[] strings = br.readLine().split(" ");
            int negativeCount = 0;
            int positive = 0;
            int count = 0;
            for (int i = 0; i < strings.length; i++) {
                int temp=Integer.parseInt(strings[i]) ;
                if (temp< 0) {
                    negativeCount++;
                } else if (temp>0){
                    positive += temp;
                    count++;
                }
            }

            System.out.println(negativeCount + " " + Math.round(positive * 10.0 / count) / 10.0);
//            System.out.print(negativeCount + " ");
//            System.out.format("%.1f",(float)positive/count);
        }
    }
}
