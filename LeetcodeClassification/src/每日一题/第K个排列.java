package ÿ��һ��;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/5 20:11
 * 60. ��k������
 * https://leetcode-cn.com/problems/permutation-sequence/
 * <p>
 * �ο��ⷨ��https://leetcode-cn.com/problems/permutation-sequence/solution/di-kge-pai-lie-shu-xue-gui-na-on2-by-acw_weian/
 */
public class ��K������ {
    /**
     * ������
     * <p>
     * �Ӹ�λ����λ���ο���ÿһλ��
     * ����ÿһλ����С��������ö��δʹ�ù�������ȷ����ǰλ�Ǽ���
     * Ϊ�˱�����⣬�����������һ�����ӵľ��������n=4,k=14��
     * �������ǽ��������а���λ���飺
     * <p>
     * 1 + (2, 3, 4��ȫ����)
     * 2 + (1, 3, 4��ȫ����)
     * 3 + (1, 2, 4��ȫ����)
     * 4 + (2, 3, 4��ȫ����)
     * ����������ȷ���� k=14����������һ���С�ÿ������и����� 3!=6�������Ե�14�������ڵ�3���У�������λ�Ѿ�����ȷ������3��
     * <p>
     * Ȼ�������ٽ���3������м������飺
     * <p>
     * 31 + (2, 4��ȫ����)
     * 32 + (1, 4��ȫ����)
     * 34 + (1, 2��ȫ����)
     * �����������жϵ� k=14���������ĸ�С���С���������� 14�������ڵ��������ŵڼ�������ǰ����ÿ����6�����У����Ե�14�������ڵ�3���ŵ�
     * 14?6?2=2��
     * �ڵ�������ÿ��С������и����� 2!=2�������Ե� k �������ڵ�1��С�飬���Կ���ȷ�����ĵڶ�λ������1��
     * <p>
     * �������ƣ������Ƴ���14�������� 3142��
     * <p>
     * ʱ�临�Ӷȷ���������ѭ��������ʱ�临�Ӷ��� O(n^2)��
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];   // ���ڴ�Ž׳˵�
        fact[0] = 1;   // 0! = 1
        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i - 1];
        }

        boolean[] visited = new boolean[n + 1]; // ���ڼ�¼�������Ƿ񱻷���
        StringBuilder sb = new StringBuilder();  // ���ڴ�����յĽ��

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {  // ��ǰ���ֻ�δ������
                    if (k <= fact[n - i]) {   // ��ǰk����fact[n-i]��
                        sb.append(j);    // ȡ j ��λ
                        visited[j] = true;
                        break;
                    }
                    // ���ڸ÷��� fact[n- i]
                    k -= fact[n - i];
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ��K������ m = new ��K������();
        System.out.println(m.getPermutation(4, 14));
    }

}
