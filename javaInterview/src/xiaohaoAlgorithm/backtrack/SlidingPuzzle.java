package xiaohaoAlgorithm.backtrack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/28 10:22
 *
 * 773. 滑动谜题
 */
public class SlidingPuzzle {
    /**
     *  采用bfs暴力求解  + 剪枝-- 这时需要一维数组
     *  首先将二位数组转为一维数组，存的是 : 在一维字符串中，索引i在二维数组中的相邻索引为neighbor[i]
     *  eg：neighbor[4] = {1,3,5}  表示0（索引为4）的相邻元素有5（索引为3）、4（索引为1）、3（索引为5）
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";  // 目标字符串 也就是要走到赢了的字符串至少需要多少步
        char[] ch = new char[6];  // 题目中给出的2*3布局
        int index = 0;
        // 将二位数组转为一维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ch[index++] = (char)(board[i][j] + '0');  // 相当于 0 -> ‘0’  1 --> '1'
            }
        }

        String start = new String(ch);

        // 记录一维字符串的相邻索引
        int[][] neighbor = {
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {3,1,5},
                {2,4}
        };

        /**
         * BFS算法框架
         */
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        int step = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String curr = q.poll();
                // 判断当前是否达到目标局面
                if (target.equals(curr)) return step;

                // 找到数字 0 的索引
                int position = curr.indexOf('0');
                int[] exchanges = neighbor[position];
                for (int p : exchanges) {
                    // 交换元素
                    String str = swap(curr, p, position);
                    // 防止走回路
                    if (!visited.contains(str)) {
                        q.offer(str);
                        visited.add(str);
                    }
                }
            }
            step++;
        }

        // 不能解开谜板，则返回 -1 。
        return -1;
    }

    private String swap(String curr, int p, int position) {
        char[] chars = curr.toCharArray();
        char temp = chars[position];
        chars[position] = chars[p];
        chars[p] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        SlidingPuzzle s = new SlidingPuzzle();
        int[][] board = {{1,2,3},{5,0,4}};
        int count = s.slidingPuzzle(board);
        System.out.println("至少需要 " + count + " 步完成");
    }
}
