/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class Test28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        int[] arr = new int[102400000];   // ͳ��ÿ�����ֳ��ֵĴ���
        int count = 0;  // ͳ��Ŀ�����ֵĳ��ֵĴ���
        for (int i = 0; i < len; i++) {
            arr[array[i]] ++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > (len / 2)) {
                return i;
            }
        }
        return 0;
    }



}
