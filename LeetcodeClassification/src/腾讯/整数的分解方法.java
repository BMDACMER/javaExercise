package 腾讯;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/2 21:45
 * 整数的分解方法
 * 腾讯2017年笔试题  参考：https://www.cnblogs.com/xuehaoyue/p/6660315.html#_label2_0
 *
 * 运用动态规划的方法，从3开始往大数分析，构造二维数组，横坐标表示当前分析的数，纵坐标表示当前分解情况结尾的数
 */
public class 整数的分解方法 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int result = 0;

            int[][] arr = new int[num+1][];
            for (int i = 3; i <= num; i++) {
                int columnNum = (int)Math.floor((i-1)/2d);
                arr[i] = new int[columnNum];
                for (int j = 0; j < columnNum; j++) {
                    arr[i][j] = 1;
                    int num2 = j + 1;
                    int num1 = i - num2;
                    if (num1 > 2 * num2) {  // 只有这种情况才分解
                        if (num1 % 2 == 0) { // num1是偶数，计算分解情况时+1
                            arr[i][j]++;
                        }
                        //计算数1的分解情况
                        for (int k = j; k < arr[num1].length; k++){
                            arr[i][j] += arr[num1][k];
                        }
                    }
                }
            }
            if(num == 1 || num == 2) result = 0;
            else{
                for(int i = 0; i < arr[num].length;i++){
                    result += arr[num][i];
                }
            }
            System.out.println(result);
        }
    }

}
