package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/25 23:11
 *
 * https://leetcode-cn.com/problems/counting-bits/
 * 338. ����λ����
 * ����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 *
 * ʾ�� 1:
 *
 * ����: 2
 * ���: [0,1,1]
 */
public class CountBits {

    // �����㷨
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        ans[0] = 0;  // 0תΪ�����ƺ� 1�ĸ�������Ϊ0��
        for (int i = 1; i <= num; i++) {
            int temp = 0;
            int j = i;
            while (j != 0) {
                /*temp += j & 1;
                j >>= 1;*/
                temp++;
                j &= (j-1);
            }
            ans[i] = temp;
        }
        return ans;
    }

    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
/*
    ���ߣ�LeetCode
    ���ӣ�https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
    ��Դ�����ۣ�LeetCode��
    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������*/

    public static void main(String[] args) {
        CountBits c = new CountBits();
        System.out.println(c.countBits(2));
    }
}
