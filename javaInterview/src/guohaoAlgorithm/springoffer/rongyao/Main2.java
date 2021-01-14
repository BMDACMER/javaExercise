package guohaoAlgorithm.springoffer.rongyao;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/13 16:58
 *
 * 第二题   送伞
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n != 0) {
            int c = scan.nextInt();
            int small = scan.nextInt();
            int large = scan.nextInt();
            help(c,small,large);
            n--;
        }
    }

    private static void help(int c, int small, int large) {
        // 当c的数量小于2时 只需要一趟即可
        if (c <= 2) {
            System.out.println(1);
            return;
        }

        int count = 0;
        int cTmp = c;
        //第一趟
        cTmp = c - 2;
        count++;
        // 终止条件： 食堂没人了
        while (cTmp > 0) {
            // 从公司（c - cTmp）----》食堂 cTmp
            int tmp = 0;
            if (large >= (c - cTmp) * 2) {
                tmp = (c - cTmp) * 5; // 最多可接纳tmp人
                large = large - (c - cTmp);
                cTmp -= tmp;
                count += 2;
            } else {
                // 如果第一次全部拿完 large  剩余的由small来补充
                if (large % 2 == 0) {
                    // 剩余可拿small人数
                    int res = (c - cTmp) - (large / 2);
                    tmp = large * 5;
                    // 判断small数量
                    if (small >= res * 2) {
                        // 剩余的small数量充足  可以让所有人都拿
                        tmp += res * 3;  // 此时可接纳人数为 tmp
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                    } else if (small < res * 2) {
                        if (small % 2 == 0) tmp += small * 3;
                        else tmp += (small - 1) * 3 + 1;
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                    }
                } else {

                    // 如果large 不为偶数
                    // 剩余可拿small人数
                    int res = (c - cTmp) - (large / 2);
                    tmp = (large - 1) * 5 + 2;
                    // 判断small数量
                    if (small >= res * 2) {
                        // 剩余的small数量充足  可以让所有人都拿
                        tmp += res * 3;  // 此时可接纳人数为 tmp
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                    } else if (small < res * 2) {
                        if (small % 2 == 0) tmp += small * 3;
                        else tmp += (small - 1) * 3 + 1;
                        cTmp -= tmp;
                        count += 2;
                        large = 0;
                        small = 0;
                    }
                }
            }

        }

        System.out.println(count);
    }
}
