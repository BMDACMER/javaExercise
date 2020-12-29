package xiaohaoAlgorithm.backtrack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/28 10:22
 *
 * 773. ��������
 */
public class SlidingPuzzle {
    /**
     *  ����bfs�������  + ��֦-- ��ʱ��Ҫһά����
     *  ���Ƚ���λ����תΪһά���飬����� : ��һά�ַ����У�����i�ڶ�ά�����е���������Ϊneighbor[i]
     *  eg��neighbor[4] = {1,3,5}  ��ʾ0������Ϊ4��������Ԫ����5������Ϊ3����4������Ϊ1����3������Ϊ5��
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";  // Ŀ���ַ��� Ҳ����Ҫ�ߵ�Ӯ�˵��ַ���������Ҫ���ٲ�
        char[] ch = new char[6];  // ��Ŀ�и�����2*3����
        int index = 0;
        // ����λ����תΪһά����
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ch[index++] = (char)(board[i][j] + '0');  // �൱�� 0 -> ��0��  1 --> '1'
            }
        }

        String start = new String(ch);

        // ��¼һά�ַ�������������
        int[][] neighbor = {
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {3,1,5},
                {2,4}
        };

        /**
         * BFS�㷨���
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
                // �жϵ�ǰ�Ƿ�ﵽĿ�����
                if (target.equals(curr)) return step;

                // �ҵ����� 0 ������
                int position = curr.indexOf('0');
                int[] exchanges = neighbor[position];
                for (int p : exchanges) {
                    // ����Ԫ��
                    String str = swap(curr, p, position);
                    // ��ֹ�߻�·
                    if (!visited.contains(str)) {
                        q.offer(str);
                        visited.add(str);
                    }
                }
            }
            step++;
        }

        // ���ܽ⿪�հ壬�򷵻� -1 ��
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
        System.out.println("������Ҫ " + count + " �����");
    }
}
