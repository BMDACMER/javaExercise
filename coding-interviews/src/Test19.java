import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * �����δ�ӡ������ 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Test19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];   // ��Ƿ�������
        ArrayList<Integer> ans = new ArrayList<>();   // ��ŷ��صĽ��
        int flag = 1;   // 1---> right  2-->down   3--->left    4---> up
        int x = 0, y = 0;   // ��ʼ��λ��

        while (ans.size() <= matrix.length * matrix[0].length) {   // ֱ����������е�����Ϊֹ
            // Խ��
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visit[x][y]) {
                if (flag == 1) {
                    flag = 2; // down
                    y--;   // ����Խ���Ӱ��    �Ͼ���ʱ��y�Ѿ�Խ����
                    x++;  // ����
                } else if (flag == 2) {
                    flag = 3;
                    x--;    // xԽ���ˣ�����Խ��Ӱ��
                    y--;    // ����
                } else if (flag == 3) {
                    flag = 4;
                    y++;   // y<0   ����Խ��Ӱ��
                    x--;   // ����
                } else {
                    flag = 1;
                    x++;   // x<0  ����Խ��Ӱ��
                    y--;   // ����
                }
            } else {
                ans.add(matrix[x][y]);
                visit[x][y] = true;
                if (flag == 1) {
                    y++;
                } else if (flag == 2) {
                    x++;
                } else if (flag == 3) {
                    y--;
                } else {
                    x--;
                }
            }

        }
        return ans;
    }
}
