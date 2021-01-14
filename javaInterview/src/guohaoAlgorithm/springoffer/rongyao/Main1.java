package guohaoAlgorithm.springoffer.rongyao;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/13 16:12
 *
 * ��һ��   ��ӥ׽С��
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            int[] arr1 = new int[m];
            for (int i = 0; i < m; i++) {
                arr1[i] = scan.nextInt();
            }
            int[][] arr2 = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr2[i][0] = scan.nextInt();
                arr2[i][1] = scan.nextInt();
            }

            solve(m,n,arr1,arr2);
        }
    }

    private static void solve(int m, int n, int[] arr1, int[][] arr2) {

        // �Ƚ�arr1 �����ݴ�ŵ�������
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr1.length; i++) {
            q.offer(arr1[i]);
        }
        int index = 0;

        // ���С������С��1ʱ����Ϸʧ���ҽ��������N�ֺ��ж���һֻС��
        // �ڳ�������Ϸʤ��
        while (q.size() > 1) {
            if (arr2[index][0] != arr2[index][1]) {
                // �����ɹ�
                q.remove(arr2[index][0] - 1);
            }
            n--;  // ���������Լ�
            index++;// ������һ��Ԫ��

            if (n == 0 && q.size() > 1) {
                // ˵��������ϣ� ʣ���С����������1ֻ   ��Ϸʤ��
                System.out.print("Success! ");
                Collections.sort(q);
                for (int i = 0; i < q.size() - 1; i++) {
                    System.out.print(q.get(i) + " ");
                }
                System.out.println(q.get(q.size() - 1));
                return;
            }
        }

        // ��ʱС������������1ֻ ����
        System.out.print("Fail! ");
        System.out.print(q.get(0));
    }

}
