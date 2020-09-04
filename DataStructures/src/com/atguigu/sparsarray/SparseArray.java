package com.atguigu.sparsarray;

import java.io.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/4 10:09
 */
public class SparseArray {
    public static void main(String[] args) {
        // ����һ��ԭʼ�Ķ�λ����  11 * 11
        // 0�� ��ʾû������   1 ��ʾ����  2 ��ʾ����
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 555;
        //���ԭʼ�Ķ�ά����
        System.out.println("ԭʼ�Ķ�ά����~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // ����ά���� ת ϡ�������
        // 1 �ȱ�����ά���� �õ� �� 0 ���ݵĸ���
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }

        // ����ϡ�������
        int[][] sparseArr1 = new int[sum + 1][3];
        // ��0�д洢 ��ά��������к����ݸ���
        sparseArr1[0][0] = chessArr1.length;
        sparseArr1[0][1] = chessArr1[0].length;
        sparseArr1[0][2] = 3;
        // �洢��������
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
        System.out.println("\n��ά����תΪϡ������~~~");
        // ���ϡ������
        for (int i = 0; i < sparseArr1.length; i++) {
            for (int j = 0; j < sparseArr1[0].length; j++) {
                System.out.printf("%d\t",sparseArr1[i][j]);
            }
            System.out.println();
        }


        // ��ϡ������  ---�� �ָ��� ԭʼ�Ķ�ά����
        /**
         * 1���ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�λ���飬���������chessArr2 = int[11][11]
         * 2���ڶ�ȡϡ��������е����ݣ�����ֵ��ԭʼ�Ķ�ά���鼴��
         */
        // 1 �ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά����
        int row = sparseArr1[0][0];
        int col = sparseArr1[0][1];
        int[][] chessArr2 = new int[row][col];
        for (int i = 1; i < sparseArr1.length; i++) {
            chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }

        // ��ӡ��ά����
        System.out.println("ϡ������ת��Ϊ��λ����Ϊ");
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[0].length; j++) {
                System.out.printf("%d\t", chessArr2[i][j]);
            }
            System.out.println();
        }
        /**
         * 3.1.4 �κ���ϰ
         * 1) ��ǰ��Ļ����ϣ���ϡ�����鱣�浽�����ϣ����� map.data
         * 2�� �ָ�ԭ��������ʱ����ȡ map.data ���лָ�
        */
        // ����������ݴ�ӡ�����ش�����
        File file = new File("E://sparseArray.txt");  // ����ָ���ļ�
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();   // �ļ������ڣ� �½��ļ�
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


        System.out.println("\n\n  �ָ�ԭ��������ʱ����ȡ sparseArray.txt ���лָ�");
        // 2) �ָ�ԭ��������ʱ����ȡ map.data ���лָ�
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
