package ÃÏ“Ì‘∆;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/9 22:21
 */
public class Main2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) { // a
            for (int j = 1; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        int num1 = i * 1000 + j*100 + k*10+l;
                        int num2 = j*1000+k*100+l*10+i;
                        if (num1 + num2 == 8888) {
                            System.out.println(i + " " + j + " "+ k+" " + l);
                        }
                    }
                }
            }
        }
    }
}
