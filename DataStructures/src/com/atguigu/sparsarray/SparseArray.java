package com.atguigu.sparsarray;

import java.io.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/4 10:09
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二位数组  11 * 11
        // 0： 表示没有棋子   1 表示黑子  2 表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 555;
        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组的
        // 1 先遍历二维数组 得到 非 0 数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }

        // 创建稀疏数组的
        int[][] sparseArr1 = new int[sum + 1][3];
        // 第0行存储 二维数组的行列和数据个数
        sparseArr1[0][0] = chessArr1.length;
        sparseArr1[0][1] = chessArr1[0].length;
        sparseArr1[0][2] = 3;
        // 存储非零数据
        int index = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr1[++index][0] = i;
                    sparseArr1[index][1] = j;
                    sparseArr1[index][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("\n二维数组转为稀疏数组~~~");
        // 输出稀疏数组
        for (int i = 0; i < sparseArr1.length; i++) {
            for (int j = 0; j < sparseArr1[0].length; j++) {
                System.out.printf("%d\t",sparseArr1[i][j]);
            }
            System.out.println();
        }


        // 将稀疏数组  ---》 恢复成 原始的二维数组
        /**
         * 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二位数组，比如上面的chessArr2 = int[11][11]
         * 2、在读取稀疏数组后几行的数据，并赋值给原始的二维数组即可
         */
        // 1 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int row = sparseArr1[0][0];
        int col = sparseArr1[0][1];
        int[][] chessArr2 = new int[row][col];
        for (int i = 1; i < sparseArr1.length; i++) {
            chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }

        // 打印二维数组
        System.out.println("稀疏数组转换为二位数组为");
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[0].length; j++) {
                System.out.printf("%d\t", chessArr2[i][j]);
            }
            System.out.println();
        }
        /**
         * 3.1.4 课后练习
         * 1) 在前面的基础上，将稀疏数组保存到磁盘上，比如 map.data
         * 2） 恢复原来的数组时，读取 map.data 进行恢复
        */
        // 将输出的内容打印到本地磁盘上
        File file = new File("E://sparseArray.txt");  // 创建指定文件
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();   // 文件不存在， 新建文件
            }

            fw = new FileWriter(file);
            for (int i = 0; i < chessArr2.length; i++) {
                for (int j = 0; j < chessArr2[0].length; j++) {
                    fw.write(chessArr2[i][j] + "\t");

                }
                fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println("\n\n  恢复原来的数组时，读取 sparseArray.txt 进行恢复");
        // 2) 恢复原来的数组时，读取 map.data 进行恢复
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] chars = new char[5];
            int len;
            while ((len = fr.read(chars)) != -1) {
                for (char c : chars) {
                    System.out.print(c);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
