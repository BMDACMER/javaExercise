package guohaoAlgorithm.springoffer.奇安信;

import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/3/6 16:38
 * @Version 1.0
 */
public class Main2 {

    static int min = Integer.MAX_VALUE;
    static int[][] edge = new int[100][100];
    static int[] vertex = new int[100];
    static int n, m;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        n = input.nextInt();   // 6
        int countEdges = 0;
        int start = input.nextInt();  // 0
        int end = input.nextInt();   // 5
        int a = input.nextInt();   // 0
        int b = input.nextInt();   // 1
        int c = input.nextInt();   // 2
        while (!(a==0 && b==0 && c==0)) {
            edge[a][b] = c;
            countEdges++;
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < countEdges; j++) {
                if (i == j) {
                    edge[i][j] = 0;
                } else {
                    edge[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        vertex[1] = 1;
        dfs(start, 0, end);
        System.out.println(min);
    }

    public static void dfs(int cur, int dis, int end) {
        /**
         * 如果当前路径大于之前找到的最小值，可直接返回
         * */
        if (dis > min) {
            return;
        }
        /**
         * 判断是否达到最后一个结点，更新最小值，返回
         * */
        if(cur == end) {
            if (dis < min) {
                min = dis;
                return;
            }
        }
        /**
         * 当前点到其他各点之间可连通但是还未添加进来时，遍历执行
         * */
        for (int i = 0; i < n; i++) {
            if (edge[cur][i] != Integer.MAX_VALUE && vertex[i] == 0) {
                vertex[i] = 1;
                dfs(i, dis+edge[cur][i], end);
                /**
                 * 回溯
                 **/
                vertex[i] = 0;
            }
        }
        return;
    }
}
