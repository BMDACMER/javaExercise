package guohaoAlgorithm.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/25 21:54
 *
 * 279. ��ȫƽ����
 *
 * �� 322. ��Ǯ�һ� ����
 */
public class NumSquares {

    /*// ��̬�滮  1 <= n <= 10^4     ����13.14%  32.25%
    public int numSquares(int n) {
        int[] dp = new int[n+1];  // ��ʾ �ճ�n��Ҫ�����ٸ���
        ArrayList<Integer> list = new ArrayList<>();
        // �ҳ�С�ڵ���n����ȫƽ����
        int index = 1;
        while (index * index <= n) {
            list.add(index * index);
            index++;
        }

        Arrays.fill(dp, n + 1);
        dp[0] = 0;  // base case     �ճ�0Ԫ��Ҫ0öӲ��
        for (int i = 1; i <= n; i++) {
            for (int num : list) {
                if (i - num < 0) break;  // ���� ������break
                dp[i] = Math.min(dp[i], dp[i-num] + 1);
            }
        }
        return dp[n];
        //dp[amount] == amount + 1 ? -1 : dp[amount];
    }*/

    // ��������  dfs + ̰��
    int ans = Integer.MAX_VALUE;
    public int numSquares(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int index =1;
        while (index * index <= n) {
            arr.add(index * index);
            index++;
        }

        dfs(arr, n, arr.size() - 1, 0);
        return ans;
    }

    /**
     *
     * @param arr  --- Ӳ�ҵ���ֵ
     * @param amount --- ��Ҫ�ճ�����
     * @param index --- ����   ��arr�д����������   ����̰�Ĳ���
     * @param count  --- ͳ����Ҫ����öӲ��
     */
    private void dfs(ArrayList<Integer> arr, int amount, int index, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        // ��ֹ����   ������ arr����
        if (index < 0)
            return;

        for (int i = amount / arr.get(index); i >= 0 && i + count < ans; --i) {
            dfs(arr, amount - i * arr.get(index), index - 1, count + i);
        }
    }


    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        System.out.println(n.numSquares(312));
    }
}
