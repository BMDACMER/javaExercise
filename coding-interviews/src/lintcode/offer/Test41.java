package lintcode.offer;
// 21 ��������˳��ʹ����λ��ż��ǰ��
public class Test41 {
    public void reOrderArray(int [] array) {
        int[] copy = array.clone();
        // ͳ����������
        int count = 0;
        for (int i : copy) {
            if (i % 2 != 0)
                count++;
        }

        // ��ԭ�����е�Ԫ������ copy�����У�������ǰ ż���ں�
        int i = 0, j = count;
        for (int val : copy) {
            if (val % 2 != 0) {
                array[i++] = val;
            } else {
                array[j++] = val;
            }
        }

    }
}
