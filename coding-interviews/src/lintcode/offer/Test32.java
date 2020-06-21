package lintcode.offer;

/**
 * �������˶�
 * ˼·��������������ֲ����ͣ������������ǽ��������궼��ֲ���ͣ���������������Ƚ�
 * sum < k �� ������+1���������������Բ���DFS
 */
public class Test32 {

    private int count = 0;

    public int movingCount(int threshold, int rows, int cols) {

        boolean[][] visit = new boolean[rows][cols];   // ����Ƿ���ʹ���Ĭ��Ϊfalse��
        help(threshold,visit,0,0, rows, cols);

        return count;
    }

    private void help(int threshold, boolean[][] visit, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || getTotal(r,c) > threshold || visit[r][c]) {
            return ;
        }
        if (getTotal(r, c) <= threshold){
            count++;
            visit[r][c] = true;
        }
        help(threshold, visit, r + 1, c, rows, cols);
        help(threshold, visit, r - 1, c, rows, cols);
        help(threshold, visit, r, c + 1, rows, cols);
        help(threshold, visit, r, c - 1, rows, cols);

    }

    // �������ϵ�λ�����
    private int getTotal(int r, int c) {
        int result = 0;
        while (r != 0) {
            result += r % 10;
            r /= 10;
        }
        while (c != 0) {
            result += c % 10;
            c /= 10;
        }
        return result;
    }

}
