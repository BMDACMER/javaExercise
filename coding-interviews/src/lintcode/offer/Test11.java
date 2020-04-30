package lintcode.offer;

/**
 * ������13. �����˵��˶���Χ
 *
 *
 ������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��һ�������˴����� [0, 0] �ĸ��ӿ�ʼ�ƶ���
 ��ÿ�ο��������ҡ��ϡ����ƶ�һ�񣨲����ƶ��������⣩��Ҳ���ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 ���磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] �� ��Ϊ3+5+3+7=18���������ܽ��뷽�� [35, 38]��
 ��Ϊ3+5+3+8=19�����ʸû������ܹ�������ٸ����ӣ�
 */
public class Test11 {

    public int movingCount(int m, int n, int k) {
        int count = 1;
        if (m < 1 || n < 1 || m > 100 || n > 100 || k < 0 || k > 20)
            return -1;
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (help(i,j) <= k) {
                    if (i - 1 >= 0 && visit[i-1][j]) {
                        count++;
                        visit[i][j] = true;  // ����
                    } else if (j - 1 >= 0 && visit[i][j-1]) {
                        count++;
                        visit[i][j] = true;  // ����
                    }
                }
            }
        }
        return count;
    }


    // �������ָ�λ���
    private int help(int i, int j) {
        int result = 0;
        while (i != 0) {
            result += i % 10;
            i /= 10;
        }
        while (j != 0) {
            result += j % 10;
            j /= 10;
        }
        return  result;
    }

}
