package lintcode.greed;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/26 22:16
 * 605. �ֻ�����
 * <p>
 * ˼·��ͳ�ƿ�����ֲ�Ļ����ں�n�Ƚϣ�Ҫ��n<=����ֲ�Ļ�  ����true ���򣬷���false
 * ��ֲ�����㷨�� ����±�i��ʾ��ֵ��0 ���ж���һ��
 * �����0 ��ͳ��count++
 * ����i��ת��i=i+2
 * ��1 ֱ����һ�����ظ���������
 * ֱ���������
 */
public class CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int[] tmp = new int[flowerbed.length + 2];
        tmp[flowerbed.length + 1] = 0;
        tmp[0] = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            tmp[i+1] = flowerbed[i];
        }

        for (int i = 1; i < tmp.length-1; i++) {
            if (tmp[i-1] == 0 && tmp[i] == 0 && tmp[i+1] == 0) {
                count++;
                tmp[i] = 1;
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlower canPlaceFlower = new CanPlaceFlower();
        int[] flowerbed = new int[]{0,0,1,0,0};
        System.out.println(canPlaceFlower.canPlaceFlowers(flowerbed, 1));
        ;
    }
}
