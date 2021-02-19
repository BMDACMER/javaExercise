package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/19 8:22
 * @Version 1.0
 *
 * 1004. �������1�ĸ��� III
 * ����һ�������� 0 �� 1 ��ɵ����� A�����������Խ� K ��ֵ�� 0 ��� 1 ��
 *
 * ���ؽ����� 1 �����������������ĳ��ȡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * �����6
 * ���ͣ�
 * [1,1,1,0,0,1,1,1,1,1,1]
 * �������ִ� 0 ��ת�� 1����������鳤��Ϊ 6��
 * ʾ�� 2��
 *
 * ���룺A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * �����10
 * ���ͣ�
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * �������ִ� 0 ��ת�� 1����������鳤��Ϊ 10��
 */
public class LongestOnes {

    // ����ǰ�� 424. �滻�����ظ��ַ� ����    1208  1493���һ��
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, ans = 0, count = 0;
        while (right < A.length) {
            if (A[right] == 1) count++;

            while (right - left + 1 > count + K) {
                if (A[left] == 1) count--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
