package guohaoAlgorithm.nowcoder.bytedance;

import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/3/5 15:19
 * @Version 1.0
 *
 * ��Ŀ���ӣ�https://www.nowcoder.com/practice/58b04ed2865f4ff4921290f1bd4ee486?tpId=137&tqId=33878&rp=1&ru=%2Fta%2Fexam-bytedance&qru=%2Fta%2Fexam-bytedance%2Fquestion-ranking&tab=answerKey
 */
public class ZJ1 {

    /*// ͨ�� 60%   ���г�ʱ
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scan.nextInt() - 1;
        }
        int ans = 0, roomID = 0;
        int[] visited = new int[n];
        while (roomID < n) {
            // ���ʵ�һ������ ����1�η��ʴ���
            visited[roomID] += 1;
            ans++;   // ��Ҫ����1
            if (visited[roomID] % 2 == 0) {
                roomID++;
            } else {
                roomID = p[roomID];
            }
        }
        System.out.println(ans % 1000000007);
    }
*/
    // dp  �ο����
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scan.nextInt();
        }
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i-1] % 1000000007 - dp[p[i-1] - 1] + 2) % 1000000007;
        }
        System.out.println(dp[n]);
    }
}
