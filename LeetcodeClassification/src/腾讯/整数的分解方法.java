package ��Ѷ;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/2 21:45
 * �����ķֽⷽ��
 * ��Ѷ2017�������  �ο���https://www.cnblogs.com/xuehaoyue/p/6660315.html#_label2_0
 *
 * ���ö�̬�滮�ķ�������3��ʼ�����������������ά���飬�������ʾ��ǰ�����������������ʾ��ǰ�ֽ������β����
 */
public class �����ķֽⷽ�� {

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
                    if (num1 > 2 * num2) {  // ֻ����������ŷֽ�
                        if (num1 % 2 == 0) { // num1��ż��������ֽ����ʱ+1
                            arr[i][j]++;
                        }
                        //������1�ķֽ����
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
