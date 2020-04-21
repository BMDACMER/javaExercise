import java.util.PriorityQueue;

/**
 * �������е���λ��
 *
 *��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ������ʹ��Insert()������ȡ��������
 * ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 */
public class Test64 {

    // �󶥶�  �洢����Ԫ��
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2-o1);   // �൱������
    // С���ѣ��洢�Ұ��Ԫ�أ������Ұ��Ԫ�ض���������
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;    // ��ǰ������Ԫ�صĸ���

    public void Insert(Integer num) {
        if (N % 2 == 0) {
            left.add(num);        // ������  �󶥶�   ����
        } else {
            right.add(num);   // ������  С����   ����
        }
        //��������ݿ��ܳ��� ���������������������� ��Ҫ���²���
        if (!right.isEmpty() && left.peek() > right.peek()) {
            int temp1 = left.poll();
            int temp2 = right.poll();
            left.add(temp2);
            right.add(temp1);
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) left.peek();
        }
    }

}
