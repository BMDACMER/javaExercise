package lintcode.offer;

/**
 * ������17. ��ӡ��1������nλ��
 * �������� n����˳���ӡ���� 1 ������ n λʮ���������������� 3��
 * ���ӡ�� 1��2��3 һֱ������ 3 λ�� 999��
 */
public class Test16 {
    public int[] printNumbers(int n) {
        int num=(int)Math.pow(10,n);
        int[] arr=new int[num-1];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        return arr;

        /**
        //��ΪnΪ��������������СΪ10��Ҳ���԰�10��Ϊ9��100��Ϊ99��
        int[] map = { 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000,
                100_000_000, 1_000_000_000, Integer.MAX_VALUE };
        int size = map[n-1];
        int[] ans = new int[size - 1];
        for (int i = 1; i < size; i++) {
            ans[i - 1] = i;
        }
        return ans;

        ���ߣ�hteason
        ���ӣ�https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/javada-biao-bu-jie-zhu-mathpow-by-hteason/
        ��Դ�����ۣ�LeetCode��
        ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
        */
    }
}
