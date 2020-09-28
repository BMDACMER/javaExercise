package 牛客网.算法初级班;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/18 21:12
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 假设农场中有成熟的母牛每年只会生1头小母牛，并且永不会死。第一年农场有1只成熟的母牛，
 * 从第二年开始，母牛开始生小母牛，每只小母牛三年之后成熟又可以生小母牛，给定正数N，
 * 求出N年后的牛的数量。。
 * 所有的牛都不会死，所以第n-1年的牛会毫无损失地活到第n年。同时。所有成熟的牛都会生1头新的牛，
 * 那么成熟的牛的数量就是第n-3年的所有牛，到第n年的肯定都是成熟的牛。其间出生的牛肯定都没有成熟。
 * 所以C(N)=C(N-1)+C(N-3).
 * 初始项 C（1）==1  C(2)==2  C(3)==3
 * 与斐波那契特别类似。
 */
public class Main {
   public int[] isPrimeArr(int[] arr) {
       int[] res = new int[arr.length];
       int index = 0;
       for (int i = 0; i < arr.length; i++) {
           if (isPrime(arr[i])) {
               res[index++] = arr[i];
           }
       }
       return res;
   }

    private static boolean isPrime(int src) {
        double sqrt = Math.sqrt(src);
        if (src < 2) {
            return false;
        }
        if (src == 2 || src == 3) {
            return true;
        }
        if (src % 2 == 0) {// 先判断是否为偶数，若偶数就直接结束程序
            return false;
        }
        for (int i = 3; i <= sqrt; i+=2) {
            if (src % i == 0) {
                return false;
            }
        }
        return true;
    }
}
