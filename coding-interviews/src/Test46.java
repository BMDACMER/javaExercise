/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,
 * ����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
 * ����,Ҫ����ʹ�������ģ������Ĺ���, Ȼ���������LL��������Σ� ����������˳�Ӿ����true����������false��
 * Ϊ�˷������,�������Ϊ��С����0��
 */
public class Test46 {
    /**
     *   max ��¼ ���ֵ
         min ��¼  ��Сֵ
         min ,max ������0
         ��������
         1 max - min <5
         2 ��0��û���ظ�������(��)
         3 ���鳤�� Ϊ5
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5 || numbers == null) {
            return false;
        }
        int max = -1;
        int min = 14;  // �ܹ�14�Ų�ͬ����  ��С����ʾ0
        int len = numbers.length;
        // ͳ��ÿ���Ƴ��ֵĴ���
        int[] card = new int[14];
        for (int i = 0; i < len; i++) {
            card[numbers[i]]++;
            if (numbers[i] == 0) {
                // ��ʾ��С��
                continue;
            }

            // ����ڶ��������ظ�
            if (card[numbers[i]] > 1) {
                return false;
            }

            if (max < numbers[i]) {
                max = numbers[i];
            }
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        // �����һ��
        if (max - min < 5) {
            return true;
        }
        return false;
    }
}
