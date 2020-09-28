package ţ����.�㷨������;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/18 21:12
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ����ũ�����г����ĸţÿ��ֻ����1ͷСĸţ������������������һ��ũ����1ֻ�����ĸţ��
 * �ӵڶ��꿪ʼ��ĸţ��ʼ��Сĸţ��ÿֻСĸţ����֮������ֿ�����Сĸţ����������N��
 * ���N����ţ����������
 * ���е�ţ�������������Ե�n-1���ţ�������ʧ�ػ��n�ꡣͬʱ�����г����ţ������1ͷ�µ�ţ��
 * ��ô�����ţ���������ǵ�n-3�������ţ������n��Ŀ϶����ǳ����ţ����������ţ�϶���û�г��졣
 * ����C(N)=C(N-1)+C(N-3).
 * ��ʼ�� C��1��==1  C(2)==2  C(3)==3
 * ��쳲������ر����ơ�
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
        if (src % 2 == 0) {// ���ж��Ƿ�Ϊż������ż����ֱ�ӽ�������
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
