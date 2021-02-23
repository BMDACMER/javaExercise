package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/23 8:35
 * @Version 1.0
 *
 * 1052. ������������ϰ�
 * ���죬����ϰ���һ�ҵ������Ӫҵ customers.length ���ӡ�ÿ���Ӷ���һЩ�˿ͣ�customers[i]���������꣬������Щ�˿Ͷ�������һ���ӽ������뿪��
 *
 * ��ĳЩʱ������ϰ�������� �������ϰ��ڵ� i ������������ô grumpy[i] = 1������ grumpy[i] = 0�� ������ϰ�����ʱ����һ���ӵĹ˿;ͻ᲻���⣬������������������ġ�
 *
 * ����ϰ�֪��һ�����ܼ��ɣ��������Լ����������������Լ����� X ���Ӳ���������ȴֻ��ʹ��һ�Ρ�
 *
 * ���㷵����һ��Ӫҵ����������ж��ٿͻ��ܹ��е������������
 *
 *
 * ʾ����
 *
 * ���룺customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * �����16
 * ���ͣ�
 * ����ϰ������ 3 ���ӱ����侲��
 * �е���������ͻ����� = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class MaxSatisfied {

    // �ο���https://leetcode-cn.com/problems/grumpy-bookstore-owner/solution/yong-mi-mi-ji-qiao-wan-liu-zhu-zui-duo-d-py41/
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int[] arr = new int[customers.length];
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) sum += customers[i];
            else arr[i] = customers[i];
        }
        int now = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i - X >= 0) now -= arr[i-X];
            now += arr[i];
            max = Math.max(max, now);
        }
        return max + sum;
    }
}
