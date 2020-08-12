import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/10 15:10
 *
 * https://www.nowcoder.com/practice/caf35ae421194a1090c22fe223357dca?tpId=37&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * ?计算一个数字的立方根，不使用库函数
 *
 * 详细描述：
 *
 * ?接口说明
 *
 * 原型：
 *
 * public static double getCubeRoot(double input)
 *
 * 输入:double 待求解参数
 *
 * 返回值:double  输入参数的立方根，保留一位小数
 */
public class HJ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            double input = Double.parseDouble(str);
            System.out.println(getCubeRoot(input));
        }
        br.close();
    }

    private static Double getCubeRoot(double input) {
        double diff = 0.0000001;
        double start = 0.0;
        double end = input;
        double middle = 0.0;
        while (end - start > diff) {
            middle = start + (end - start) / 2;
            if (middle * middle * middle > input) {
                end = middle;
            } else if (middle * middle * middle < input) {
                start = middle;
            } else {
                return middle;
            }
        }
        return Math.round(end*10.0)/10.0;
    }
}
