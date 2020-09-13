package 滴滴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/13 19:39
 * 1、滴滴第一题  破解X星人的密文
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String str;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                str = br.readLine();
                System.out.println(getRes(n, str));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

    public static String getRes(int n, String str) {
        int len = str.length();
        int nLen = len/n;
        StringBuilder sb = new StringBuilder();  // 存放最终的结果

        int start = 0, end = n;
        while (nLen != 0) {
            String substring = str.substring(start, end);
            // 逆序
            for (int j = n-1; j >= 0; j--) {
                sb.append(substring.charAt(j));
            }
            start = end;
            end = end + n;
            nLen--;
        }


        for (int i = len - 1; i >= end - n; --i) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
