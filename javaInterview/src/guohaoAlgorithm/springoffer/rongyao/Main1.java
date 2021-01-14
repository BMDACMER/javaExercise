package guohaoAlgorithm.springoffer.rongyao;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/13 16:12
 *
 * 第一题   老鹰捉小鸡
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

        // 先将arr1 的数据存放到队列中
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr1.length; i++) {
            q.offer(arr1[i]);
        }
        int index = 0;

        // 如果小即个数小于1时，游戏失败且结束，如果N轮后还有多余一只小鸡
        // 在场，则游戏胜利
        while (q.size() > 1) {
            if (arr2[index][0] != arr2[index][1]) {
                // 攻击成功
                q.remove(arr2[index][0] - 1);
            }
            n--;  // 攻击次数自减
            index++;// 自增下一组元素

            if (n == 0 && q.size() > 1) {
                // 说明攻击完毕， 剩余的小鸡数量大于1只   游戏胜利
                System.out.print("Success! ");
                Collections.sort(q);
                for (int i = 0; i < q.size() - 1; i++) {
                    System.out.print(q.get(i) + " ");
                }
                System.out.println(q.get(q.size() - 1));
                return;
            }
        }

        // 此时小鸡数量不多于1只 结束
        System.out.print("Fail! ");
        System.out.print(q.get(0));
    }

}
