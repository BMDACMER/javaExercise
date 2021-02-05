package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/5 9:32
 *
 * 1208. ������ʹ�ַ������
 * ��������������ͬ���ַ�����s �� t��
 *
 * �� s �еĵ� i ���ַ��䵽 t �еĵ� i ���ַ���Ҫ |s[i] - t[i]| �Ŀ�������������Ϊ 0����Ҳ���������ַ��� ASCII ��ֵ�Ĳ�ľ���ֵ��
 *
 * ���ڱ���ַ��������Ԥ���� maxCost����ת���ַ���ʱ���ܿ���Ӧ��С�ڵ��ڸ�Ԥ�㣬��Ҳ��ζ���ַ�����ת�������ǲ���ȫ�ġ�
 *
 * �������Խ� s �����ַ���ת��Ϊ���� t �ж�Ӧ�����ַ������򷵻ؿ���ת������󳤶ȡ�
 *
 * ��� s ��û�����ַ�������ת���� t �ж�Ӧ�����ַ������򷵻� 0��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "abcd", t = "bcdf", cost = 3
 * �����3
 * ���ͣ�s �е� "abc" ���Ա�Ϊ "bcd"������Ϊ 3��������󳤶�Ϊ 3��
 */
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] abs = new int[len];
        for (int i = 0; i < len; i++) {
            abs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        // ��abs���л������ڲ���
        int left = 0, right = 0, sum = 0, ans = 0;
        while (right < len) {
            sum += abs[right];
            while (sum > maxCost) {
                sum -= abs[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
