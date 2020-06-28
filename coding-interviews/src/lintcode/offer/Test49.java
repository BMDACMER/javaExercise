package lintcode.offer;
import java.util.ArrayList;

public class Test49 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];  // Ĭ��Ϊfalse
        ArrayList<Integer> list = new ArrayList<>();   // ������Ž������
        int flag = 1;   // 1-->right   2--->down   3--->left   4--->up
        int x = 0, y = 0;   // ��¼������ʼ��Ϊ��0��0������
        while (list.size() < matrix.length * matrix[0].length) {
            // Խ��
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visit[x][y]) {
                if (flag == 1) { // �ƶ������Ҷ�
                    flag = 2;   // ����
                    x++;
                    y--;  // ����Խ��Ӱ��
                } else if (flag == 2) {
                    flag = 3; // ����
                    x--;   // ����Խ��Ӱ��
                    y--;
                } else if (flag == 3) {
                    flag = 4;  // ����
                    x--;  // ����Խ��Ӱ��
                    y++;
                } else if (flag == 4) {
                    flag = 1;  // ����
                    x++;
                    y++; // ����Խ��Ӱ��
                }
            } else {
                list.add(matrix[x][y]);
                visit[x][y] = true;
                if (flag == 1)
                    y++;
                if (flag == 2)
                    x++;
                if (flag == 3)
                    y--;
                if (flag == 4)
                    x--;
            }
        }
        return list;
    }
}
