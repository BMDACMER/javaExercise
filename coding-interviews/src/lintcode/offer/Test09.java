package lintcode.offer;

/**
 * ������11. ��ת�������С����
 *
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ����������������һ����ת��
 * �����ת�������СԪ�ء����磬����?[3,4,5,1,2] Ϊ [1,2,3,4,5] ��һ����ת�����������СֵΪ1��??

 ��Դ�����ۣ�LeetCode��
 ���ӣ�https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Test09 {
    // ���ֲ���
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;
            if (numbers[mid] < numbers[j]) {
                j = mid;
            } else if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else {
                j --;
            }
        }
        return numbers[i];
    }
}
